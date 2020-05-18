package io.amin.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Embeddable
public class JobHistoryId implements Serializable {

    @OneToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Override
    public String toString() {
        return "JobHistoryId{" +
                "employee.id=" + employee.getId() +
                ", startDate=" + startDate +
                '}';
    }

}
