package com.leverx.spring.test.workers.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobs")
@SQLUpdate(sql = "" +
        "UPDATE jobs " +
        "SET deleted = true " +
        "WHERE id = ?")
@Loader(namedQuery = "findJobById")
@NamedQuery(name = "findJobById", query =
            "SELECT j " +
            "FROM Job j " +
            "WHERE j.id = ?1 " +
            "AND j.deleted = FALSE")
@Where(clause = "deleted = false")
public class Job extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(
            fetch = LAZY,
            cascade = { PERSIST, MERGE },
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
