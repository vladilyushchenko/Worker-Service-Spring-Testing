package com.leverx.spring.test.workers.mapper;

import com.leverx.spring.test.workers.dto.JobDto;
import com.leverx.spring.test.workers.entity.Job;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring", uses = ShortcutWorkerMapper.class)
public interface JobMapper {

    @Mapping(source = "workers", target = "workersDto")
    JobDto mapEntityToDto(Job job);

    @Mapping(source = "workersDto", target = "workers")
    Job mapDtoToEntity(JobDto jobDto);

    Set<Job> mapDtoSetToEntity(Set<JobDto> jobsDto);

    Set<JobDto> mapEntitySetToDto(Set<Job> jobs);
}