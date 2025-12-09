package com.java.training.registerservice.repository;

import com.java.training.registerservice.model.RegisterComplaint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegisterComplaintRepository extends MongoRepository<RegisterComplaint, String> {
    RegisterComplaint findByComplaintId(String complaintId);
}
