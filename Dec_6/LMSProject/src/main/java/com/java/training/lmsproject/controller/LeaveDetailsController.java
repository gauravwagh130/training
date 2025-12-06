package com.java.training.lmsproject.controller;

import com.java.training.lmsproject.model.LeaveDetails;
import com.java.training.lmsproject.repository.LeaveDetailsRepository;
import com.java.training.lmsproject.service.LeaveDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeaveDetailsController {
    @Autowired
    LeaveDetailsService leaveDetailsService;

    @PostMapping(value = "/applyLeave")
    public ResponseEntity<String> applyLeave(@RequestBody LeaveDetails leaveDetails) {
        String result = leaveDetailsService.applyLeave(leaveDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(value = "/showLeaves/{empId}")
    public ResponseEntity<List<LeaveDetails>> showLeave(@PathVariable int empId) {
        List<LeaveDetails> leaves = leaveDetailsService.showEmpLeave(empId);
        if (leaves == null || leaves.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(leaves);
        }
        return ResponseEntity.ok(leaves);
    }

    @PostMapping(value = "/approveDeny/{leaveId}/{mgrId}/{status}")
    public ResponseEntity<String> approveDeny(@PathVariable int leaveId, @PathVariable int mgrId, @PathVariable String status) {
        String result = leaveDetailsService.approveDeny(leaveId, mgrId, status);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
//        return leaveDetailsService.approveDeny(leaveId, mgrId, status);
    }
    @GetMapping(value="/showPendingLeaves/{empId}")
    public ResponseEntity<List<LeaveDetails>> showPendingLeave(@PathVariable int empId) {
        List<LeaveDetails> leaves = leaveDetailsService.showEmpPendingLeaves(empId);
        if (leaves == null || leaves.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(leaves);
        }
        return ResponseEntity.ok(leaves);

    }
}
