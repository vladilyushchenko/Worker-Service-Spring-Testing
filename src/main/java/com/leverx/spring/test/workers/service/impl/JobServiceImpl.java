package com.leverx.spring.test.workers.service.impl;

import com.leverx.spring.test.workers.dto.JobDto;
import com.leverx.spring.test.workers.entity.Job;
import com.leverx.spring.test.workers.entity.Worker;
import com.leverx.spring.test.workers.mapper.JobMapper;
import com.leverx.spring.test.workers.mapper.WorkerMapper;
import com.leverx.spring.test.workers.repository.JobRepository;
import com.leverx.spring.test.workers.service.JobService;
import com.leverx.spring.test.workers.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

import static com.google.common.collect.Sets.newHashSet;

@Service
@Transactional
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final JobMapper jobMapper;
    private final WorkerService workerService;
    private final WorkerMapper workerMapper;

    @Override
    public Set<JobDto> findAll() {
        return jobMapper.mapEntitySetToDto(
                newHashSet(jobRepository.findAllWithFetchedWorkers())
        );
    }

    @Override
    public JobDto create(JobDto jobDto) {
        return jobMapper.mapEntityToDto(
                jobRepository.save(
                        jobMapper.mapDtoToEntity(jobDto)
                )
        );
    }

    @Override
    public JobDto update(JobDto jobDto) {
        return jobMapper.mapEntityToDto(
                jobRepository.save(
                        jobMapper.mapDtoToEntity(jobDto)
                )
        );
    }

    @Override
    public void deleteById(Long id) {
        jobRepository.deleteById(id);
    }

    @Override
    public void addWorkerToJob(Long jobId, UUID workerId) {
        Job job = jobRepository.findById(jobId).orElseThrow(
                () -> new RuntimeException("No job with id " + jobId + ")))")
        );
        Worker worker = workerMapper.mapDtoToEntity(workerService.findById(workerId));
        job.addWorker(worker);
        jobRepository.save(job);
    }
}
