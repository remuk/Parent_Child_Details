package de.api.details.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "parent_summary")
public class ParentSummary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amountOfPersons")
    private Long amountOfPersons;

    @Column(name = "amountOfChildren")
    private Long amountOfChildren;

    public ParentSummary() {}

    public ParentSummary(Long amountOfPersons, Long amountOfChildren) {
        this.setAmountOfPersons(amountOfPersons);
        this.setAmountOfChildren(amountOfChildren);
    }


    public Long getAmountOfPersons() {
        return amountOfPersons;
    }

    public void setAmountOfPersons(Long amountOfPersons) {
        this.amountOfPersons = amountOfPersons;
    }

    public Long getAmountOfChildren() {
        return amountOfChildren;
    }

    public void setAmountOfChildren(Long amountOfChildren) {
        this.amountOfChildren = amountOfChildren;
    }
}
