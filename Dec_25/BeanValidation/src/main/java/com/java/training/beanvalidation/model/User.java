package com.java.training.beanvalidation.model;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    @NotBlank(message = "Name id required...")
    private String name;
    @Email(message = "Invalid Email format...")
    @NotBlank(message = "Email is required...")
    private String email;

    @NotNull(message = "Age Cannot be Null")
    @Min(message = "Age must be 18 years...", value = 18)
    @Max(message = "Age cannot grater than 80",  value = 80)
    private Integer age;
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid Mobile number...")
    private String mobile;
    public User() { }

    public User(String id, String name, String email, Integer age, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
