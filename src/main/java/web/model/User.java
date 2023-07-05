package web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users_table")
public class User {


    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Size(min = 1, max = 50, message = "Name is too long")
    @NotEmpty(message = "Name is empty")
    private String name;

    @Column
    @Min(value = 0, message = "No tachyons belong here!")
    @Max(value = 200, message = "Vampires are not allowed")
    private int age;


    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return name + " " + age;
    }
}