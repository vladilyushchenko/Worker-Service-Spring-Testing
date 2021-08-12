package com.leverx.spring.test.workers.mapper;

import com.leverx.spring.test.workers.dto.WorkerDto;
import com.leverx.spring.test.workers.entity.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = JobMapper.class)
public interface WorkerMapper {

    WorkerMapper WORKER_MAPPER = Mappers.getMapper(WorkerMapper.class);

    @Mapping(source = "jobs", target = "jobsDto")
    WorkerDto mapFromEntityToDto(Worker worker);

    @Mapping(source = "jobsDto", target = "jobs")
    Worker mapFromDtoToEntity(WorkerDto workerDto);
}

//
//import com.leverx.spring.test.workers.dto.JobDto;
//import com.leverx.spring.test.workers.dto.WorkerDto;
//import com.leverx.spring.test.workers.dto.WorkerWithoutJobDto;
//import com.leverx.spring.test.workers.entity.Job;
//import com.leverx.spring.test.workers.entity.Worker;
//import org.mapstruct.Mapper;
//
//import java.util.Set;
//
//import static java.util.stream.Collectors.toSet;
//
//@Mapper(componentModel = "spring")
//public abstract class WorkerMapper {
//
//    public Worker mapDtoToEntity(WorkerDto workerDto) {
//        Worker worker = Worker.builder()
//                .password(workerDto.getPassword())
//                .name(workerDto.getName())
//                .id(workerDto.getId())
//                .build();
//        if (workerDto.getJobsDto() != null) {
//            Set<Job> jobs = workerDto.getJobsDto().stream()
//                    .map(jobDto -> {
//                                Job job = new Job(jobDto.getId(), jobDto.getName(), null);
//                                job.setWorkers(jobDto.getWorkersWithoutJobDto().stream()
//                                        .map(this::getWorkerWithoutJob)
//                                        .collect(toSet()));
//                                return job;
//                            }
//                    ).collect(toSet());
//            worker.setJobs(jobs);
//        }
//        return worker;
//    }
//
//    public WorkerDto mapEntityToDto(Worker worker) {
//        WorkerDto workerDto = WorkerDto.builder()
//                .id(worker.getId())
//                .name(worker.getName())
//                .password(worker.getPassword())
//                .build();
//
//        if (worker.getJobs() != null) {
//            Set<JobDto> jobsDto = worker.getJobs().stream()
//                    .map(job -> {
//                        JobDto jobDto = new JobDto(job.getId(), job.getName(), null);
//                        jobDto.setWorkersWithoutJobDto(job.getWorkers().stream()
//                                .map(this::getWorkerDtoWithoutJob)
//                                .collect(toSet()));
//                        return jobDto;
//                    }).collect(toSet());
//            workerDto.setJobsDto(jobsDto);
//        }
//        return workerDto;
//    }
//
//    private WorkerWithoutJobDto getWorkerDtoWithoutJob(Worker worker) {
//        return WorkerWithoutJobDto.builder()
//                .id(worker.getId())
//                .name(worker.getName())
//                .password(worker.getPassword())
//                .build();
//    }
//
//    private Worker getWorkerWithoutJob(WorkerDto workerDto) {
//        return Worker.builder()
//                .password(workerDto.getPassword())
//                .name(workerDto.getName())
//                .id(workerDto.getId())
//                .build();
//    }
//
//    public abstract Set<Worker> mapDtoSetToEntity(Set<WorkerDto> workersDto);
//
//    public abstract Set<WorkerDto> mapEntitySetToDto(Set<Worker> workers);
//}
