package com.java.training.lmsproject.repository;

import com.java.training.lmsproject.model.LeaveDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LeaveDetailsRepository extends MongoRepository<LeaveDetails, String> {
    LeaveDetails findFirstByOrderByLeaveIdDesc();
    List<LeaveDetails> findByEmpId(int empId);
    LeaveDetails findByLeaveId(int leaveId);
}
