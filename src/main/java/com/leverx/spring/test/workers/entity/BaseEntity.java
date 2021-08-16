package com.leverx.spring.test.workers.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import static java.lang.Boolean.FALSE;

@MappedSuperclass
public class BaseEntity {

    @Column(name = "deleted")
    private Boolean deleted = FALSE;
}
