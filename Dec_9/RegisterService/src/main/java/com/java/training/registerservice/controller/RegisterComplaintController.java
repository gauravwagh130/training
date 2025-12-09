package com.java.training.registerservice.controller;

import com.java.training.registerservice.model.RegisterComplaint;
import com.java.training.registerservice.service.RegisterComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegisterComplaintController {
    @Autowired
    private RegisterComplaintService registerComplaintService;

    @GetMapping(value = "/searchComplaint/{complaintId}")
    public ResponseEntity<RegisterComplaint> showComplaint(@PathVariable String complaintId) {
        RegisterComplaint rc = registerComplaintService.findByComplaintId(complaintId);
        return ResponseEntity.ok(rc);
//        return registerComplaintService.findByComplaintId(complaintId);
    }
    @GetMapping(value = "/showAllComplaint")
    public ResponseEntity<List<RegisterComplaint>> showAllComplaint() {
        return ResponseEntity.ok(registerComplaintService.findAll());
    }

    @PostMapping(value = "/addComplaint")
    public ResponseEntity<String> addComaplaint(@RequestBody RegisterComplaint registerComplaint) {
        registerComplaintService.addComplaint(registerComplaint);
        return ResponseEntity.ok("Complaint added Successfully...");
    }

    @PutMapping(value = "/updateComplaint/{complaintId}")
    public ResponseEntity<String> updateComplaint(@PathVariable String complaintId, @RequestBody RegisterComplaint registerComplaint) {
        registerComplaintService.updateComplaint(complaintId, registerComplaint);
        return ResponseEntity.ok("Complaint updated Successfully...");
    }
    @DeleteMapping(value = "/delete/complaintId")
    public ResponseEntity<String> deleteComplaint(@PathVariable String complaintId) {
        registerComplaintService.deleteComplaint(complaintId);
        return ResponseEntity.ok("Complaint deleted Successfully...");
    }
}
