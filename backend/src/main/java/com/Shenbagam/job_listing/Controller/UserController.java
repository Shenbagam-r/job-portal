package com.Shenbagam.job_listing.Controller;

import com.Shenbagam.job_listing.Model.Users;
import com.Shenbagam.job_listing.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
   public ResponseEntity<Users> addUser(@RequestBody Users user)
   {
       return new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);
   }
   @GetMapping("/")
    public String greet()
   {
       return "Backend is running";
   }

   @PostMapping("/api/auth/signup")
    public ResponseEntity<String> addUsers(@RequestBody Users user)
   {
       userService.addUser(user);
       return new ResponseEntity<>("User registered",HttpStatus.OK);
   }
}
