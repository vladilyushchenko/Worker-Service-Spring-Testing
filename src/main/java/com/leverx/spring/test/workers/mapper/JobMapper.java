package com.leverx.spring.test.workers.mapper;

import com.leverx.spring.test.workers.dto.JobDto;
import com.leverx.spring.test.workers.entity.Job;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface JobMapper {

    JobMapper JOB_MAPPER = Mappers.getMapper(JobMapper.class);

    JobDto matFromEntityToDto(Job job);

    @InheritInverseConfiguration
    Job mapFromDtoToEntity(JobDto jobDto);
}

//
//import com.google.common.collect.Sets;
//import com.leverx.spring.test.workers.dto.JobDto;
//import com.leverx.spring.test.workers.entity.Job;
//import org.mapstruct.Mapper;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Set;
//
//@Mapper(componentModel = "spring")
//public abstract class JobMapper {
//
//    @Autowired
//    private WorkerMapper workerMapper;
//
//    public JobDto mapEntityToDto(Job job) {
//        return new JobDto(job.getId(), job.getName(),
//                job.getWorkers() != null
//                        ? workerMapper.mapEntitySetToDto(Sets.newHashSet(job.getWorkers()))
//                        : null);
//    }
//
//    public Job mapDtoToEntity(JobDto jobDto) {
//        return new Job(jobDto.getId(), jobDto.getName(),
//                jobDto.getWorkersDto() != null
//                        ? workerMapper.mapDtoSetToEntity(jobDto.getWorkersDto())
//                        : null);
//    }
//
//    public abstract Set<Job> mapDtoListToEntity(Set<JobDto> jobsDto);
//
//    public abstract Set<JobDto> mapEntityListToDto(Set<Job> jobs);
//}
