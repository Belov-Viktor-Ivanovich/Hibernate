package org.example;

import jakarta.persistence.*;


@Entity
@Table(name = "Film")
public class Film {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id",referencedColumnName = "id",foreignKey = @ForeignKey(
            name = "director_id",foreignKeyDefinition = ""
    ))
    private Director director;

    public Film(){}
    public Film(String name, Director director) {
        this.name = name;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director=" + director +
                '}';
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

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
