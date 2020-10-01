package main.java.by.epamtc.bobkov.bean;

import java.io.Serializable;
import java.util.Objects;

public class UserData implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String surname;
    private String login;
    private int age;
    private String email;
    private String phoneNumber;

    public UserData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return age == userData.age &&
                Objects.equals(name, userData.name) &&
                Objects.equals(surname, userData.surname) &&
                Objects.equals(login, userData.login) &&
                Objects.equals(email, userData.email) &&
                Objects.equals(phoneNumber, userData.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, login, age, email, phoneNumber);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
