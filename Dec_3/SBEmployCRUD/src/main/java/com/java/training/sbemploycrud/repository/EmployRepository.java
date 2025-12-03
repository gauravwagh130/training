package com.java.training.sbemploycrud.repository;

import com.java.training.sbemploycrud.model.Employ;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployRepository extends MongoRepository<Employ,String> {
    Employ findByEmpno(int empno);
}
