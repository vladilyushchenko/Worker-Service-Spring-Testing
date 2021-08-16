package com.leverx.spring.test.workers.mapper;

import com.leverx.spring.test.workers.dto.WorkerDto;
import com.leverx.spring.test.workers.entity.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring", uses = ShortcutJobMapper.class)
public interface WorkerMapper {

    @Mapping(source = "jobs", target = "jobsDto")
    WorkerDto mapEntityToDto(Worker worker);

    @Mapping(source = "jobsDto", target = "jobs")
    Worker mapDtoToEntity(WorkerDto workerDto);

    Set<WorkerDto> mapEntitySetToDto(Set<Worker> workers);

    Set<Worker> mapDtoSetToEntity(Set<WorkerDto> workersDto);
}