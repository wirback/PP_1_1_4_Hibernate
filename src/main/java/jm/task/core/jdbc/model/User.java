package jm.task.core.jdbc.model;

import javax.persistence.*;

@Entity
@Table(name = "usersTable")
public class User {
    @Override
    public String toString() {
        return String.format("""
                        
                        User = id: %d | name: %s | lastName: %s | age: %d"""
                , getId(), getName(), getLastName(), getAge()
        );
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "lastname", length = 50)
    private String lastName;

    @Column(name = "age")
    private Byte age;

    public User() {

    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return this.age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }
}
