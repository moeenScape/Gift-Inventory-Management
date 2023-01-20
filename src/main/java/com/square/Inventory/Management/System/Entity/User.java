package com.square.Inventory.Management.System.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;
    @NotBlank
    private String lastName;

    @Pattern(regexp = "^(?:\\+?88|0088)?01[15-9]\\d{8}$", message = "Number Must be valid Number")
    private String contactNumber;

    @Email
    private String email;

    @NotBlank
    private String password;

    @Pattern(regexp = "^(admin|depot|SSU)$", message = "role will be admin or depot or SSUDtoForBudget")
    private String role;

    @Pattern(regexp = "^(active|deactivate)$", message = "role must be active or deactivate")
    private String status;

    private String otp;

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
