package io.amin.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "HIRE_DATE")
    private LocalDate hireDate;

    @Column(name = "SALARY")
    private Double salary;

    @Column(name = "COMMISSION_PCT")
    private Float commissionPct;

    @ManyToOne
    @JoinColumn(name = "JOB_ID", nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    private Set<Employee> subordinates = new HashSet<>();

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ((job != null) ? ", job.id=" + job.getId() : "job: null" )+
                ((department != null) ? ", department.id=" + department.getId() : "department: null" )+
                ((manager != null) ? ", manager.id=" + manager.getId() : "manager: null" )+
                ((subordinates != null) ? ", subordinates.size=" + subordinates.size() : "subordinates: null" )+
                '}';
    }

}
