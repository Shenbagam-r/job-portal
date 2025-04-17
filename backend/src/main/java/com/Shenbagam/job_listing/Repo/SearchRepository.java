package com.Shenbagam.job_listing.Repo;

import com.Shenbagam.job_listing.Model.JobVacancyDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SearchRepository {

    public List<JobVacancyDetails> findByText(String text);
}
