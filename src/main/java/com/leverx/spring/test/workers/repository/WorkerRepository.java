package com.leverx.spring.test.workers.repository;

import com.leverx.spring.test.workers.entity.Worker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WorkerRepository extends CrudRepository<Worker, UUID> {

    @Query("SELECT DISTINCT w FROM Worker w LEFT JOIN FETCH w.jobs")
    List<Worker> findAllWithFetchedJobs();
}
