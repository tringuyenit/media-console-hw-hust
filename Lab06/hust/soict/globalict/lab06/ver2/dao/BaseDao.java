package hust.soict.globalict.lab06.ver2.dao;

import hust.soict.globalict.lab06.ver2.fakedb.FakeDB;

import java.util.List;

public interface BaseDao <T>{
    FakeDB fakedb = new FakeDB(); // genarates fake database

    List<T> findAll();
    T findById(int id);
}
