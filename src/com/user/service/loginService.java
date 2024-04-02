package com.user.service;

import com.user.entity.Student;
import com.user.entity.Teacher;
import com.user.entity.User;

public interface loginService {
    Student loginService(User u);
    Teacher loginService1(User u);
}
