package com.square.Inventory.Management.System.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName") // does not match datbase column
    private String firstName;

    @Column(name = "lastName") // does not match datbase column
    private String lastName;

    @Pattern(regexp = "^(?:\\+?88|0088)?01[15-9]\\d{8}$", message = "Number Must be valid Number")
    @Column(name = "contactNumber") // does not match datbase column
    private String contactNumber;

    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Pattern(regexp = "^(admin|depot|SSU)$", message = "role will be admin or depot or SSU")
    private String role;

    @Column(name = "status")
    @Pattern(regexp = "^(true|false)$", message = "role true or false")
    private String status;

    @Column(name = "otp")
    private String otp;

    @Column(name = "otp_generation_time")
    private Date setOtpGenerationTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Date getSetOtpGenerationTime() {
        return setOtpGenerationTime;
    }

    public void setSetOtpGenerationTime(Date setOtpGenerationTime) {
        this.setOtpGenerationTime = setOtpGenerationTime;
    }
}
