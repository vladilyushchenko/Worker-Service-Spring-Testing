package com.leverx.spring.test.workers.repository.impl;

import com.leverx.spring.test.workers.entity.Job;
import com.leverx.spring.test.workers.entity.Worker;
import com.leverx.spring.test.workers.repository.JobRepository;
import com.leverx.spring.test.workers.repository.WorkerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class WorkerRepositoryTest {

    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private JobRepository jobRepository;

    @Test
    public void findAllWithFetchedJobs_ShouldFetchJobs() {
        List<Worker> workers = workerRepository.findAllWithFetchedJobs();
        assertTrue(workers.stream().anyMatch(worker -> worker.getJobs().size() != 0));
    }

    @Test
    public void persistWithNotPersistedJob_ShouldPersistNewJob() {
        Worker worker = getNotPersistedWorkerWithNotPersistentJob();
        worker = workerRepository.save(worker);
        Long jobId = worker.getJobs().iterator().next().getId();
        UUID workerId = worker.getId();
        assertTrue(workerRepository.existsById(workerId));
        assertTrue(jobRepository.existsById(jobId));
    }

    Worker getNotPersistedWorkerWithNotPersistentJob() {
        Job job = getNotPersistentJob();
        Worker worker = Worker.builder()
                .name("n3")
                .password("p3")
                .jobs(newHashSet())
                .build();
        worker.addJob(job);
        return worker;
    }

    Job getNotPersistentJob() {
        return new Job(null, "new job 1", newHashSet());
    }

}