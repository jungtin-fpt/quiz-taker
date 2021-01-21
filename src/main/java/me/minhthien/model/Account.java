package me.minhthien.model;

import java.time.LocalDate;

public class Account {
    private int email;
    private String name;
    private String password;
    private String role;
    private String status;
    private LocalDate createDate;
    
    public Account() {
    }
    
    public Account(int email, String name, String password, String role, String status,
        LocalDate createDate) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
        this.status = status;
        this.createDate = createDate;
    }
    
    /*
    *   Getters & Setters
    * */
    
    public int getEmail() {
        return email;
    }
    
    public void setEmail(int email) {
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
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
    
    public LocalDate getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
    
    @Override
    public String toString() {
        return "Account{" +
            "email=" + email +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", role='" + role + '\'' +
            ", status='" + status + '\'' +
            ", createDate=" + createDate +
            '}';
    }
}
