package io.amin.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "DEPARTMENTS")
public class Department {

    @Id
    @Column(name = "DEPARTMENT_ID")
    private Integer id;

    @Column(name = "DEPARTMENT_NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    @OneToMany(mappedBy = "department")
    private Set<JobHistory> jobHistories = new HashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees = new HashSet<>();

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager.id=" + manager.getId() +
                ", location.id=" + location.getId() +
                ", jobHistories.size=" + jobHistories.size() +
                ", employees.size=" + employees.size() +
                '}';
    }

}
