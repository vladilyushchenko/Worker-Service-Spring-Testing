package com.leverx.spring.test.workers.repository;

import com.leverx.spring.test.workers.entity.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {
}
