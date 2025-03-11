package com.abdulazeez.renew_hub.model;

import jakarta.persistence.*;

@Entity
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private String id;
 private String fullNane;
 private String email;
 private String password;
 private String phoneNumber;

 @Enumerated(EnumType.STRING)
 private Role role;

 public String getId() {
  return id;
 }

 public void setId(String id) {
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


