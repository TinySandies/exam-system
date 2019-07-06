package top.tinysand.dao;

import top.tinysand.model.Student;

import java.util.List;

public interface IUserDao {
    List<Student> findAll();

    Student findById(String id);

    void addUser(Student user) throws Exception;

    void edit(Student user) throws Exception;

    void delete(String id) throws Exception;
}
