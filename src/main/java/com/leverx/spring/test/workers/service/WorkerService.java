package com.leverx.spring.test.workers.service;

import com.leverx.spring.test.workers.dto.WorkerDto;
import java.util.List;
import java.util.UUID;

public interface WorkerService {

    List<WorkerDto> findAll();

    WorkerDto create(WorkerDto workerDto);

    WorkerDto update(WorkerDto workerDto);

    void deleteById(UUID id);
}
