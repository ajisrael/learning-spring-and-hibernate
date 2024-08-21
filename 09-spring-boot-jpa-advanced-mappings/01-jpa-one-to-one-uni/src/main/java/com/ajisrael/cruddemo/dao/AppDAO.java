package com.ajisrael.cruddemo.dao;

import com.ajisrael.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int theId);
}
