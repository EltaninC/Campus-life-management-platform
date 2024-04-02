package com.user.service;

import com.user.entity.Repairform;

import java.util.ArrayList;

public interface addService {
    void addService(Repairform a);

    ArrayList<Repairform> getAllApply(String s_id);
}
