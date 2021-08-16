package com.leverx.spring.test.workers.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

import static com.google.common.collect.Sets.newHashSet;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity
@Builder
@Table(name = "workers")
@NoArgsConstructor
@AllArgsConstructor
public class Worker {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = LAZY, cascade = { PERSIST })
    @JoinTable(
            name = "jobs_workers",
            joinColumns = @JoinColumn(name = "worker_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private Set<Job> jobs;

    public void addJob(Job job) {
        if (this.jobs == null) {
            jobs = newHashSet();
        }
        this.jobs.add(job);
        job.getWorkers().add(this);
    }

    public void removeJob(Job job) {
        if (this.jobs != null) {
            this.jobs.remove(job);
            job.getWorkers().remove(this);
        }
    }
}
