package io.amin.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "JOB_HISTORY")
public class JobHistory {

    @EmbeddedId
    private JobHistoryId jobHistoryId;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "JOB_ID")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @Override
    public String toString() {
        return "JobHistory{" +
                "jobHistoryId=" + jobHistoryId +
                ", endDate=" + endDate +
                ", job.id=" + job.getId() +
                ", department.id=" + department.getId() +
                '}';
    }

}
