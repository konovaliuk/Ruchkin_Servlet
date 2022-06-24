package com.pis.Entity;

public record User(Integer id, String name, String surname, String email, String password) {

    public User(Integer id,String name, String surname, String email, String password){

            this.id = id;
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.password = password;
        }

    public User(String name, String surname, String email, String password) {
        this(null, name, surname, email, password);
    }



}
