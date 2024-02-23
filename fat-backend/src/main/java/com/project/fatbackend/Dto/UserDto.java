package com.project.fatbackend.Dto;

import com.project.fatbackend.Entity.User;

public class UserDto {

    private String name;
    private String email;
    private Long phoneNo;

    public UserDto() {
    }

    public UserDto(String name, String email, Long phoneNo) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public UserDto(User user){
        this.name = user.getName();
        this.phoneNo = user.getPhoneNo();
        this.email = user.getEmail();
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

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }
}
