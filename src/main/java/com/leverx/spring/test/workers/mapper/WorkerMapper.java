package com.leverx.spring.test.workers.mapper;

import com.leverx.spring.test.workers.dto.WorkerDto;
import com.leverx.spring.test.workers.entity.Worker;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring", uses = ShortcutJobMapper.class)
public interface WorkerMapper {

    WorkerDto mapEntityToDto(Worker worker);

    Worker mapDtoToEntity(WorkerDto workerDto);

    Set<WorkerDto> mapEntitySetToDto(Set<Worker> workers);

}