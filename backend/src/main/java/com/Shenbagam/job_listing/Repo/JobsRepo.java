package com.Shenbagam.job_listing.Repo;

import com.Shenbagam.job_listing.Model.JobVacancyDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobsRepo extends MongoRepository<JobVacancyDetails,String>
{

}
