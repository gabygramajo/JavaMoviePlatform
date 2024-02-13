package org.gabydev.app.model;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class Category {
    @Id
    //auto incremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name_category")
    private String nameCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public String toString() {
        return id +
                ", " + nameCategory;
    }
}
