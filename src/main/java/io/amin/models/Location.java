package io.amin.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "LOCATIONS")
public class Location {

    @Id
    @Column(name = "LOCATION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locations_generator")
    @SequenceGenerator(name = "locations_generator", sequenceName = "LOCATIONS_SEQ", allocationSize = 100)
    private Integer id;

    @Column(name = "STREET_ADDRESS")
    private String street;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STATE_PROVINCE")
    private String state;

    @OneToMany(mappedBy = "location")
    Set<Department> departments;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    Country country;

}

