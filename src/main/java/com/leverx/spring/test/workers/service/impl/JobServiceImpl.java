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
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final JobMapper jobMapper;
    private final WorkerService workerService;
    private final WorkerMapper workerMapper;

    @Override
    @Transactional
    public Set<JobDto> findAll() {
        return null;
//        return jobMapper.mapEntityListToDto(
//                fetchLazyWorkers(
//                        newHashSet(jobRepository.findAll())
//                )
//        );
    }

    @Override
    public JobDto create(JobDto jobDto) {
        return null;
//        return jobMapper.mapEntityToDto(
//                jobRepository.save(
//                        jobMapper.mapDtoToEntity(jobDto)
//                )
//        );
    }

    @Override
    public JobDto update(JobDto jobDto) {
        return null;
//        return jobMapper.mapEntityToDto(
//                jobRepository.save(
//                        jobMapper.mapDtoToEntity(jobDto)
//                )
//        );
    }

    @Override
    public void deleteById(Long id) {
        jobRepository.deleteById(id);
    }

    @Override
    public void addWorkerToJob(Long jobId, UUID workerId) {
        //        Job job = jobRepository.findById(jobId).orElseThrow(
//                () -> new RuntimeException("No job with id " + jobId +  ")))")
//        );
//        Worker worker = workerMapper.mapDtoToEntity(workerService.findById(workerId));
//        worker.getJobs().add(job);
//
//        job.getWorkers().add(worker);
//        jobRepository.save(job);
    }

    private Set<Job> fetchLazyWorkers(Set<Job> jobs) {
        jobs.forEach(job -> job.getWorkers().size());
        return jobs;
    }
}
