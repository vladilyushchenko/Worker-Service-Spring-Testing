package com.leverx.spring.test.workers.repository;

import com.leverx.spring.test.workers.entity.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkerRepository extends CrudRepository<Worker, UUID> {
}
