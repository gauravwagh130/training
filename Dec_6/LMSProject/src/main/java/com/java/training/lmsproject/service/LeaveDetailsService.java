package com.java.training.lmsproject.service;

import com.java.training.lmsproject.model.Employee;
import com.java.training.lmsproject.model.LeaveDetails;
import com.java.training.lmsproject.repository.EmployeeRepository;
import com.java.training.lmsproject.repository.LeaveDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveDetailsService {
    @Autowired
    private LeaveDetailsRepository leaveDetailsRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public String approveDeny(int leaveId, int mgrId, String status) {
        LeaveDetails leaveDetails = leaveDetailsRepository.findByLeaveId(leaveId);
        int eid = leaveDetails.getEmpId();
        Employee employee = employeeRepository.findByEmpId(eid);
        int mid = employee.getManagerId();
        int leaveAvail = employee.getLeaveAvail();
        int noOfDays = leaveDetails.getNoOfDays();
        if(mid != mgrId){
            return "You are not allowed to approve this leave";
        }
        if(status.equals("YES")){
            leaveDetails.setLeaveStatus("Approved");
            leaveDetailsRepository.save(leaveDetails);
            return "Leave Approved";
        } else {
            leaveDetails.setLeaveStatus("DENIED");
            leaveDetailsRepository.save(leaveDetails);
            leaveAvail+= noOfDays;
            employee.setLeaveAvail(leaveAvail);
            employeeRepository.save(employee);
            return "Leave Denied";
        }
    }

    public LeaveDetails getMaxLeaveRecord()
    {
        return leaveDetailsRepository.findFirstByOrderByLeaveIdDesc();
    }

    public List<LeaveDetails> showEmpLeave(int empId) {
        return leaveDetailsRepository.findByEmpId(empId);
    }
    public List<LeaveDetails> showEmpPendingLeaves(int empId) {
        List<LeaveDetails> leaveDetails = leaveDetailsRepository.findByEmpId(empId);
        return leaveDetails.stream().filter(x-> x.getLeaveStatus().equals("PENDING")).collect(Collectors.toList());
    }
    @Transactional
    public String applyLeave(LeaveDetails leaveDetails) {
        System.out.println("Leave details: " + leaveDetails.getEmpId());

        if (leaveDetails == null) return "Invalid leave details";
        Employee employee = employeeRepository.findByEmpId(leaveDetails.getEmpId());
        if (employee == null) return "Employee not found";

        if (leaveDetails.getLeaveStartDate() == null || leaveDetails.getLeaveEndDate() == null)
            return "Start and end dates are required";

        ZoneId zone = ZoneId.systemDefault();
        LocalDate today = LocalDate.now(zone);
        LocalDate start = Instant.ofEpochMilli(leaveDetails.getLeaveStartDate().getTime())
                .atZone(zone).toLocalDate();
        LocalDate end = Instant.ofEpochMilli(leaveDetails.getLeaveEndDate().getTime())
                .atZone(zone).toLocalDate();


        if (end.isBefore(start)) {
            return "Leave end date cannot be before start date";
        }

        if (start.isBefore(today)) {
            return "Leave start date cannot be in the past";
        }


        long daysLong = ChronoUnit.DAYS.between(start, end) + 1;
        if (daysLong <= 0) return "Invalid leave duration";
        if (daysLong > Integer.MAX_VALUE) return "Leave duration too large";

        int weekdays = 0;
        for (LocalDate d = start; !d.isAfter(end); d = d.plusDays(1)) {
            switch (d.getDayOfWeek()) {
                case SATURDAY:
                case SUNDAY:
                    break;
                default:
                    weekdays++;
            }
        }

        if (weekdays <= 0) return "Requested range has no weekdays to charge";

        int balance = employee.getLeaveAvail();
        if (weekdays > balance)
            return "Insufficient leave balance. Available: " + balance + ", required: " + weekdays;

        // apply
        employee.setLeaveAvail(balance - weekdays);
        leaveDetails.setNoOfDays(weekdays);
        leaveDetails.setAppliedOn(new Date());
        leaveDetails.setLeaveStatus("PENDING");


        LeaveDetails max = getMaxLeaveRecord();
        int lid = (max == null) ? 1 : (max.getLeaveId() + 1);
        leaveDetails.setLeaveId(lid);

        leaveDetailsRepository.save(leaveDetails);
        employeeRepository.save(employee);

        return "Leave Applied Successfully";
    }

}