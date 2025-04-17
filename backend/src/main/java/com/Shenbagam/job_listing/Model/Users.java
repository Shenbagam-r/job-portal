package com.Shenbagam.job_listing.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UsersDB")
public class Users
{
   private String username;
   @Id
   private String email;
   private String password;

   private Role role;

   public Users() {
   }


   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
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

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Users(String username,String email, String password, Role role) {
      this.username = username;
      this.password = password;
      this.role = role;
   }

   @Override
   public String toString() {
      return "Users{" +
              ", username='" + username + '\'' +
              ", email='" + email + '\'' +
              ", password='" + password + '\'' +
              ", role=" + role +
              '}';
   }
}
