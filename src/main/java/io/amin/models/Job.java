package io.amin.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "JOBS")
public class Job {

    @Id
    @Column(name = "JOB_ID")
    private String id;

    @Column(name = "JOB_TITLE", nullable = false)
    private String title;

    @Column(name = "MIN_SALARY")
    private Integer minSalary;

    @Column(name = "MAX_SALARY")
    private Integer maxSalary;

    @OneToMany(mappedBy = "job")
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "job")
    private Set<JobHistory> jobHistories = new HashSet<>();

}
