package de.api.details.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "child")
@Inheritance(
        strategy = InheritanceType.SINGLE_TABLE
)
@DiscriminatorColumn(name = "Gender_Type")
public class Child implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String childName;

    @Column(name = "age")
    private Integer childAge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", nullable = false)
    private Parent parent;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "child")
    @OrderBy("invented DESC")
    private Set<Meal> meal = new LinkedHashSet<>();

    public Child() {}

    public Child(String childName, Integer childAge) {
        this.setChildName(childName);
        this.setChildAge(childAge);
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public Integer getChildAge() {
        return childAge;
    }

    public void setChildAge(Integer childAge) {
        this.childAge = childAge;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Set<Meal> getMeal() {
        return meal;
    }

    public void setMeal(Set<Meal> meal) {
        this.meal = meal;
    }
}
