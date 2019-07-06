package top.tinysand.service;

import top.tinysand.model.Student;

import java.util.List;

public interface IUserService {
    List<Student> findAll();

    Student findById(String id);

    void add(Student user) throws Exception;

    void edit(Student user) throws Exception;

    void delete(String id) throws Exception;
}
