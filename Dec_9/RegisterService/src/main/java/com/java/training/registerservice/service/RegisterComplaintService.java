package com.java.training.registerservice.service;

import com.java.training.registerservice.model.RegisterComplaint;
import com.java.training.registerservice.repository.RegisterComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterComplaintService {
    @Autowired
    private RegisterComplaintRepository registerComplaintRepository;
    public List<RegisterComplaint> findAll() {
        return registerComplaintRepository.findAll();
    }
    public RegisterComplaint findByComplaintId(String complaintId) {
        return registerComplaintRepository.findByComplaintId(complaintId);
    }
    public String addComplaint(RegisterComplaint complaint) {
        registerComplaintRepository.save(complaint);
        return "Complaint added Successfully...";
    }

    public String updateComplaint(String complaintId, RegisterComplaint complaint) {
        RegisterComplaint rs = registerComplaintRepository.findByComplaintId(complaintId);
        rs.setComplaintType(complaint.getComplaintType());
        rs.setComplaintDescription(complaint.getComplaintDescription());
        rs.setSeverity(complaint.getSeverity());
        rs.setStatus(complaint.getStatus());
        registerComplaintRepository.save(rs);
        return "Complaint updated Successfully...";
    }
    public String deleteComplaint(String complaintId) {
        RegisterComplaint rs = registerComplaintRepository.findByComplaintId(complaintId);
        registerComplaintRepository.delete(rs);
        return "Complaint deleted Successfully...";
    }
}
