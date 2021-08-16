package com.leverx.spring.test.workers.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "jobs")
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(
            fetch = LAZY,
            mappedBy = "jobs"
    )
    private Set<Worker> workers;

    public void addWorker(Worker worker) {
        if (this.workers == null) {
            this.workers = newHashSet();
        }
        this.workers.add(worker);
        worker.getJobs().add(this);
    }

    public void removeWorker(Worker worker) {
        if (this.workers != null) {
            this.workers.remove(worker);
            worker.getJobs().remove(this);
        }
    }
}
