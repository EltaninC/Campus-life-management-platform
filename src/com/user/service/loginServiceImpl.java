package com.user.service;

import com.user.dao.loginDao;
import com.user.dao.loginDaoImpl;
import com.user.entity.Student;
import com.user.entity.Teacher;
import com.user.entity.User;

public class loginServiceImpl implements loginService{

    @Override
    public Student loginService(User u) {
        loginDao ld = new loginDaoImpl();
        return ld.loginDao(u);
    }

    @Override
    public Teacher loginService1(User u) {
        loginDao ld = new loginDaoImpl();
        return ld.loginDao1(u);
    }
}
