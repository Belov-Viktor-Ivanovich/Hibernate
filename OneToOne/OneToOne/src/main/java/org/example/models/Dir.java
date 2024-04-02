package org.example.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Dir")
public class Dir {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToOne(mappedBy = "dir")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Scool scool;

    public Dir(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Scool getScool() {
        return scool;
    }

    public void setScool(Scool scool) {
        this.scool = scool;
        scool.setDir(this);
    }

    @Override
    public String toString() {
        return "Dir{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scool=" + scool +
                '}';
    }

    public Dir(String name) {
        this.name = name;
    }
}
