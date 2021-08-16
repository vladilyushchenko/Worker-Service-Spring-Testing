package com.leverx.spring.test.workers.repository.impl;

import com.leverx.spring.test.workers.entity.Job;
import com.leverx.spring.test.workers.repository.JobRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class JobRepositoryTest {

    @Autowired
    private JobRepository jobRepository;

    @Test
    void findAllWithFetchedWorkers_ShouldFetchWorkers() {
        List<Job> jobs = jobRepository.findAllWithFetchedWorkers();
        assertTrue(jobs.stream().anyMatch(job -> job.getWorkers().size() != 0));
    }
}