package com.leverx.spring.test.workers.service;

import com.leverx.spring.test.workers.dto.WorkerDto;

import java.util.Set;
import java.util.UUID;

public interface WorkerService {

    Set<WorkerDto> findAll();

    WorkerDto create(WorkerDto workerDto);

    WorkerDto update(WorkerDto workerDto);

    void deleteById(UUID id);

    WorkerDto findById(UUID id);
}
