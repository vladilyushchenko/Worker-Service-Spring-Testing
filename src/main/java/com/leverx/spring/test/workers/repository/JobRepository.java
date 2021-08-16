package com.leverx.spring.test.workers.repository;

import com.leverx.spring.test.workers.entity.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {

    @Query("SELECT DISTINCT j FROM Job j LEFT JOIN FETCH j.workers")
    List<Job> findAllWithFetchedWorkers();
}
