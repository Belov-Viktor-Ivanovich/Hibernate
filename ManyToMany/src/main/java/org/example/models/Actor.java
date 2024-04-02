package org.example.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany
    @JoinTable(name = "Actor_Movie",
    joinColumns = @JoinColumn(name = "actor_id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie>movies;

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return id == actor.id && Objects.equals(name, actor.name) && Objects.equals(movies, actor.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, movies);
    }

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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Actor(){}
    public Actor(String name) {
        this.name = name;
    }
}
