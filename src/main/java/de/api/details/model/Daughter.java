package de.api.details.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Daughter_Child")
public class Daughter extends Child {

    @Column(name = "hairColor")
    @NotNull
    private String hairColor;

    public Daughter() {}

    public Daughter(String childName,Integer childAge,String hairColor) {
        super(childName,childAge);
        this.hairColor = hairColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
}
