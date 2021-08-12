package com.leverx.spring.test.workers.service;

import com.leverx.spring.test.workers.dto.JobDto;

import java.util.Set;
import java.util.UUID;

public interface JobService {

    Set<JobDto> findAll();

    JobDto create(JobDto jobDto);

    JobDto update(JobDto jobDto);

    void deleteById(Long id);

    void addWorkerToJob(Long jobId, UUID workerId);
}
