package com.suprevida.suprevida.entyties;


import jakarta.persistence.*;

@Entity(name = "users")
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private  String login;

    @Column(nullable = false)
    private  String password;

    public UserEntity(String login, String password) {
        this.login =  login;
        this.password =  password;
    }
    public   UserEntity(){}


    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
