package com.Shenbagam.job_listing.Repo;

import com.Shenbagam.job_listing.Model.JobVacancyDetails;
import com.Shenbagam.job_listing.Repo.SearchRepository;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ImplSearchRepository implements SearchRepository {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<JobVacancyDetails> findByText(String text) {

        final List<JobVacancyDetails> posts=new ArrayList<>();


        MongoDatabase database = client.getDatabase("JobPortal");
        MongoCollection<Document> collection = database.getCollection("Jobs");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query",text)
                                        .append("path", Arrays.asList("profile", "desc", "techs")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));


        result.forEach(doc->posts.add(converter.read(JobVacancyDetails.class,doc)));

        return posts;
    }
}
