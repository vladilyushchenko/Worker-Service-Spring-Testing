package com.leverx.spring.test.workers.mapper;

import com.leverx.spring.test.workers.entity.Job;
import com.leverx.spring.test.workers.entity.Worker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static java.util.UUID.randomUUID;

@SpringBootTest
class WorkerMapperUnitTest {

    private static Long jobsCounter = 0L;
    @Autowired
    private WorkerMapper workerMapper;

    @Test
    void mapperMapsEntityToDto_ShouldNotThrowStackOverflow() {
        Worker worker = getDetachedWorkerWithJobs();
        Assertions.assertDoesNotThrow(() -> workerMapper.mapEntityToDto(worker));
    }

    private Worker getDetachedWorkerWithJobs() {
        Set<Job> jobs = getDetachedJobs();
        Worker worker1 = getDetachedWorkerWithoutJobs();
        Worker worker2 = getDetachedWorkerWithoutJobs();
        jobs.forEach(job -> job.setWorkers(Set.of(worker1, worker2)));
        worker1.setJobs(jobs);
        worker2.setJobs(jobs);
        return worker1;
    }

    private Worker getDetachedWorkerWithoutJobs() {
        return Worker.builder()
                .id(randomUUID())
                .name("DETACHED-WORKER-1")
                .password("DETACHED-PASS-1")
                .build();
    }

    private Set<Job> getDetachedJobs() {
        return Set.of(getDetachedJob(), getDetachedJob());
    }

    private Job getDetachedJob() {
        return new Job(jobsCounter++, "DETACHED-JOB", null);
    }
}