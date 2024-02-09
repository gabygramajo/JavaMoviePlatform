package org.gabydev.app.entity;

public class Director {
    private String fullName;
    private String nationality;
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
        return "fullName='" + fullName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", oscar=" + oscar;
    }
}
