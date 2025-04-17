package com.Shenbagam.job_listing.Service;

import com.Shenbagam.job_listing.Model.Users;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    Users addUser(Users user);
}
