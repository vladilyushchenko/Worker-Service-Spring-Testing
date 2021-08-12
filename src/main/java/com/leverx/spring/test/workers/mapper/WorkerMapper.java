package com.leverx.spring.test.workers.mapper;

import com.leverx.spring.test.workers.dto.WorkerDto;
import com.leverx.spring.test.workers.entity.Worker;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkerMapper {

    Worker mapDtoToEntity(WorkerDto workerDto);

    List<WorkerDto> mapEntityListToDto(List<Worker> workers);

    WorkerDto mapEntityToDto(Worker worker);
}
