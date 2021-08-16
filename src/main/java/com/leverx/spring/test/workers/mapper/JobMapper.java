package com.leverx.spring.test.workers.mapper;

import com.leverx.spring.test.workers.dto.JobDto;
import com.leverx.spring.test.workers.entity.Job;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring", uses = ShortcutWorkerMapper.class)
public interface JobMapper {

    JobDto mapEntityToDto(Job job);

    Job mapDtoToEntity(JobDto jobDto);

    Set<JobDto> mapEntitySetToDto(Set<Job> jobs);
}