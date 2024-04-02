package com.user.service;

import com.user.dao.addDao;
import com.user.dao.addDaoImpl;
import com.user.dao.repairFormDao;
import com.user.dao.repairFormDaoImpl;
import com.user.entity.Repairform;

import java.util.ArrayList;

public class addServiceImpl implements addService{
    public void addService(Repairform a) {
        addDao ad = new addDaoImpl();
        ad.addDao(a);
    }

    @Override
    public ArrayList<Repairform> getAllApply(String s_id) {
        repairFormDao ad1 = new repairFormDaoImpl();
        return ad1.getAllApply(s_id);
    }
}
