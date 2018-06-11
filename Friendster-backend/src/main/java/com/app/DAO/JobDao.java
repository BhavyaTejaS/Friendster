package com.app.DAO;

import com.app.Models.Job;

import java.util.List;

public interface JobDao {
void saveJob(Job job);
List<Job> getActiveJobs();//Active is true,for other role
//For admin get all jobs
List<Job> getInActiveJobs();

}
