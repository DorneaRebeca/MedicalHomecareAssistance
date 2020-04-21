package com.example.springdemo.services;

import java.sql.Date;

public interface UserServiceInterface {

    Object login(String email, String password) throws Exception;

     Object logout();

//     Object register(String name, String email, Date birthDate, String gender, String address, String password) throws GeneralException;

}
