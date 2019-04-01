package de.api.details.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "meal")
public class Meal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String mealname;

    @Column(name = "invented")
    private Date invented;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_id", nullable = false)
    private Child child;

    public Meal() {}

    public Meal(String mealname,Date invented) {
        this.setMealname(mealname);
        this.setInvented(invented);
    }


    public String getMealname() {
        return mealname;
    }

    public void setMealname(String mealname) {
        this.mealname = mealname;
    }

    public Date getInvented() {
        return invented;
    }

    public void setInvented(Date invented) {
        this.invented = invented;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
