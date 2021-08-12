package com.leverx.spring.test.workers.controller;

import com.leverx.spring.test.workers.dto.WorkerDto;
import com.leverx.spring.test.workers.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;

    @GetMapping
    public ResponseEntity<Set<WorkerDto>> findAll() {
        return ok(workerService.findAll());
    }

    @PostMapping
    public ResponseEntity<WorkerDto> createWorker(@RequestBody WorkerDto workerDto) {
        return ok(workerService.create(workerDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkerDto> updateWorker(@PathVariable UUID id, @RequestBody WorkerDto workerDto) {
        workerDto.setId(id);
        return ok(workerService.create(workerDto));
    }

    @DeleteMapping("/{id}")
    public void deleteWorkerById(@PathVariable UUID id) {
        workerService.deleteById(id);
    }
}
