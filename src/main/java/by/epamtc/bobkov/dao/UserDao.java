package main.java.by.epamtc.bobkov.dao;

import main.java.by.epamtc.bobkov.bean.AuthorizationData;
import main.java.by.epamtc.bobkov.bean.RegistrationData;
import main.java.by.epamtc.bobkov.bean.UserData;

public interface UserDao {
    UserData authorization(AuthorizationData authorizationData);
    boolean reegistration(RegistrationData registrationData);
}
