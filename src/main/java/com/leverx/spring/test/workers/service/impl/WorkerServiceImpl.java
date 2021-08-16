package com.leverx.spring.test.workers.service.impl;

import com.leverx.spring.test.workers.dto.WorkerDto;
import com.leverx.spring.test.workers.entity.Job;
import com.leverx.spring.test.workers.entity.Worker;
import com.leverx.spring.test.workers.mapper.WorkerMapper;
import com.leverx.spring.test.workers.repository.WorkerRepository;
import com.leverx.spring.test.workers.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

import static com.google.common.collect.Sets.newHashSet;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;

    @Override
    public Set<WorkerDto> findAll() {
        return workerMapper.mapEntitySetToDto(
                fetchLazyJobs(
                        newHashSet(workerRepository.findAll())
                )
        );
    }

    @Override
    public WorkerDto create(WorkerDto workerDto) {
        return workerMapper.mapEntityToDto(
                workerRepository.save(
                        workerMapper.mapDtoToEntity(workerDto)
                )
        );
    }

    @Override
    public WorkerDto update(WorkerDto workerDto) {
        return workerMapper.mapEntityToDto(
                workerRepository.save(
                        workerMapper.mapDtoToEntity(workerDto)
                )
        );
    }

    @Override
    public void deleteById(UUID id) {
        workerRepository.deleteById(id);
    }

    @Override
    public WorkerDto findById(UUID id) {
        return workerMapper.mapEntityToDto(workerRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No worker with id " + id + "))))")
                )
        );
    }

    private Set<Worker> fetchLazyJobs(Set<Worker> workers) {
        workers.forEach(worker -> worker.getJobs().size());
        return workers;
    }
}
