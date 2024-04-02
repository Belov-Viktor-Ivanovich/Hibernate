package org.example.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Scool")
public class Scool implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "dir_id",referencedColumnName = "id")
    private Dir dir;
    @Column(name = "name")
    private String name;

    public Scool(){}
    public Scool(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Scool{" +
                ", name='" + name + '\'' +
                '}';
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
