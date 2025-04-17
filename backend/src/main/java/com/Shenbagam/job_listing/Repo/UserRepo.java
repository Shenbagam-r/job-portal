package com.Shenbagam.job_listing.Repo;

import com.Shenbagam.job_listing.Model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<Users,Integer>
{

    Users findByEmail(String email);
}
