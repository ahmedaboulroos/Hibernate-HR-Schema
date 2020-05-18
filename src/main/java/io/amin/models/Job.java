package io.amin.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "JOBS")
public class Job {

    @Id
    @Column(name = "JOB_ID", unique = true, nullable = false)
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

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                ", employees.size=" + employees.size() +
                ", jobHistories.size=" + jobHistories.size() +
                '}';
    }

}
