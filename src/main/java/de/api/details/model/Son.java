package de.api.details.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Son_Child")
public class Son extends Child {

    @Column(name = "bicycleColor")
    @NotNull
    private String bicycleColor;

    public Son() {}

    public Son(String childName,Integer childAge,String bicycleColor) {
        super(childName,childAge);
        this.bicycleColor = bicycleColor;
    }

    public String getBicycleColor() {
        return bicycleColor;
    }

    public void setBicycleColor(String bicycleColor) {
        this.bicycleColor = bicycleColor;
    }
}
