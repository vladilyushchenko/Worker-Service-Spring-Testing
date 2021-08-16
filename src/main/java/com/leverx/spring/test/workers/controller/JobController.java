package com.leverx.spring.test.workers.controller;

import com.leverx.spring.test.workers.dto.JobDto;
import com.leverx.spring.test.workers.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping
    public ResponseEntity<JobDto> createJob(@RequestBody JobDto jobDto) {
        return ok(jobService.create(jobDto));
    }

    @GetMapping
    public ResponseEntity<Set<JobDto>> findAll() {
        return ok(jobService.findAll());
    }

    @PostMapping("/{id}/addWorker")
    public void addWorkerToJob(@PathVariable Long id, @RequestParam("workerId") UUID workerId) {
        jobService.addWorkerToJob(id, workerId);
    }

    @DeleteMapping("/{id}")
    public void deleteJobById(@PathVariable Long id) {
        jobService.deleteById(id);
    }
}
