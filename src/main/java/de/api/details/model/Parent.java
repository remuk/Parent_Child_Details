package de.api.details.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "parent")
public class Parent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String parentName;

    @Column(name = "age")
    private Integer parentAge;

    @OneToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
                mappedBy = "parent")
    private House house;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "parent")
    private Set<Child> child = new HashSet<>();

    public Parent() {}

    public Parent(String parentName,Integer parentAge) {
        this.parentName = parentName;
        this.parentAge = parentAge;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getParentAge() {
        return parentAge;
    }

    public void setParentAge(Integer parentAge) {
        this.parentAge = parentAge;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Set<Child> getChild() {
        return child;
    }

    public void setChild(Set<Child> child) {
        this.child = child;
    }
}
