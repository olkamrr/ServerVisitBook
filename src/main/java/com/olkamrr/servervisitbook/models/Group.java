package com.olkamrr.servervisitbook.models;

import javax.persistence.*;

@Entity
@Table(name = "universityGroup")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGroup")
    private int id;
    @Column(name = "nameGroup")
    private String name;
    @Column(name = "codeGroup")
    private String code;
    @OneToOne(optional = false)
    @JoinColumn(name = "idAccount")
    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", user=" + user +
                '}';
    }
}
