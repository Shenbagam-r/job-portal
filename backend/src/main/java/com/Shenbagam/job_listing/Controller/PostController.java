package com.Shenbagam.job_listing.Controller;

import com.Shenbagam.job_listing.Model.JobVacancyDetails;
import com.Shenbagam.job_listing.Repo.JobsRepo;
import com.Shenbagam.job_listing.Repo.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
public class PostController {

    @Autowired
    private JobsRepo jobsrepo;

    @Autowired
    private SearchRepository searchRepository;

    @GetMapping("/allPosts")
    @CrossOrigin
    public List<JobVacancyDetails> listAllJobs()
    {
        return jobsrepo.findAll();
    }

    @GetMapping("/posts/{text}")
    @CrossOrigin
    public ResponseEntity<List<JobVacancyDetails>> search(@PathVariable String text)
    {
        List<JobVacancyDetails> vacancyDetails=searchRepository.findByText(text);
        return new ResponseEntity<>(vacancyDetails,HttpStatus.OK);
    }
    @PostMapping("/post")
    @CrossOrigin
    public ResponseEntity<JobVacancyDetails> addJobs(@RequestBody JobVacancyDetails vacancyDetails)
    {
        jobsrepo.save(vacancyDetails);
        return new ResponseEntity<>(vacancyDetails, HttpStatus.OK);
    }
}
