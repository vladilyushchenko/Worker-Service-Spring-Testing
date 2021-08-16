package com.leverx.spring.test.workers.entity;

import lombok.*;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

import static com.google.common.collect.Sets.newHashSet;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "workers")
@SQLDelete(sql = "" +
        "UPDATE workers " +
        "SET deleted = true " +
        "WHERE id = ?")
@Loader(namedQuery = "findWorkerById")
@NamedQuery(name = "findWorkerById", query =
        "SELECT w " +
        "FROM Worker w " +
        "WHERE w.id = ?1 " +
        "AND w.deleted = FALSE")
@Where(clause = "deleted = false")
public class Worker extends BaseEntity {

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
