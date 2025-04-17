package com.Shenbagam.job_listing.Service;

import com.Shenbagam.job_listing.Model.Users;
import com.Shenbagam.job_listing.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    @Override
    public Users addUser(Users user)
    {
        user.setPassword(encoder.encode(user.getPassword()));
       return userRepo.save(user);
    }
}
