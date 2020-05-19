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
@Table(name = "DEPARTMENTS")
public class Department {

    @Id
    @Column(name = "DEPARTMENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_generator")
    @SequenceGenerator(name = "department_generator", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 10)
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

}
