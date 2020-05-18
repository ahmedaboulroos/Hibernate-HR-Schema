package io.amin.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter

@Entity
@Table(name = "REGIONS")

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Region {

    @Id
    @Column(name = "REGION_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "REGION_NAME")
    private String name;

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
