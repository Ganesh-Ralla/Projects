package com.exam_system_service_impl;

import com.exam_system_entity.Option;
import com.exam_system_service.OptionsService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class OptionsServiceImpl implements OptionsService {
    Session s;
    Transaction t;
    Scanner sc = new Scanner(System.in);
    Option option = new Option();
    @Override
    public void createOption(SessionFactory sf) {
        option.setOptionText("A");
    }

    @Override
    public void updateOption(SessionFactory sf) {

    }

    @Override
    public void deleteOption(SessionFactory sf) {

    }

    @Override
    public void getOption(SessionFactory sf) {

    }

    @Override
    public void getAll(SessionFactory sf) {

    }
}
