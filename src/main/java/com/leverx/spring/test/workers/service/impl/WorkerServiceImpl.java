package com.leverx.spring.test.workers.service.impl;

import com.leverx.spring.test.workers.dto.WorkerDto;
import com.leverx.spring.test.workers.mapper.WorkerMapper;
import com.leverx.spring.test.workers.repository.WorkerRepository;
import com.leverx.spring.test.workers.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.google.common.collect.Lists.newArrayList;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;

    @Override
    public List<WorkerDto> findAll() {
        return workerMapper.mapEntityListToDto(newArrayList(workerRepository.findAll()));
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
}
