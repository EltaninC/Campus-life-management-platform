package com.user.dao;

import com.user.entity.Student;
import com.user.entity.Teacher;
import com.user.entity.User;

public interface loginDao {
    Student loginDao(User u);

    Teacher loginDao1(User u);
}
