package top.tinysand.dao;

import top.tinysand.model.Student;

import java.util.List;

public interface IStudentRepo {
    boolean deleteStudent(Student studentId);

    boolean updateStudent(Student student);

    boolean saveStudent(Student student);

    Student queryStudent(String studentId);

    List<Student> queryStudents();
}
