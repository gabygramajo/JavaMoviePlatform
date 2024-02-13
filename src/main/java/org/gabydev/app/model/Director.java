package org.gabydev.app.model;

import javax.persistence.*;

@Entity
@Table(name="directors")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String fullName;
    @Column(name="country")
    private String nationality;
    @Column(name="oscar")
    private Boolean oscar;

    public Director() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Boolean getOscar() {
        return oscar;
    }

    public void setOscar(Boolean oscar) {
        this.oscar = oscar;
    }

    @Override
    public String toString() {
        return fullName +
                ", " + nationality +
                ", oscar=" + oscar;
    }
}
