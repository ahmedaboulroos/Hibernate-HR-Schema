package io.amin.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "EMP_DETAILS_VIEW")
public class EmployeesDetailsView {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;

    @Column(name = "JOB_ID", nullable = false)
    private Integer jobId;

    @Column(name = "MANAGER_ID")
    private Integer managerId;

    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;

    @Column(name = "LOCATION_ID")
    private Integer locationId;

    @Column(name = "COUNTRY_ID")
    private Integer countryId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "SALARY")
    private Double salary;

    @Column(name = "COMMISSION_PCT")
    private Float commissionPct;

    @Column(name = "DEPARTMENT_NAME", nullable = false)
    private String departmentName;

    @Column(name = "JOB_TITLE", nullable = false)
    private String jobTitle;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STATE_PROVINCE")
    private String state;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @Column(name = "REGION_NAME")
    private String regionName;

}
