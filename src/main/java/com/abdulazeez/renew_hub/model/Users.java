package com.abdulazeez.renew_hub.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Users {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String fullNane;
 private String email;
 private String username;
 private String password;
 private String phoneNumber;


 @Enumerated(EnumType.STRING)
 private Role role;

 @OneToMany(mappedBy = "seller")
 private List<Property> properties;

 public Long getId() {
  return id;
 }

 public String getUsername() {
  return username;
 }

 public void setUsername(String username) {
  this.username = username;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getFullNane() {
  return fullNane;
 }

 public void setFullNane(String fullNane) {
  this.fullNane = fullNane;
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

 public Role getRole() {
  return role;
 }

 public void setRole(Role role) {
  this.role = role;
 }

 public String getPhoneNumber() {
  return phoneNumber;
 }

 public void setPhoneNumber(String phoneNumber) {
  this.phoneNumber = phoneNumber;
 }

}


