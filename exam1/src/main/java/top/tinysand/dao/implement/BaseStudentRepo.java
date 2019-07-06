package top.tinysand.dao.implement;

import org.springframework.stereotype.Repository;
import top.tinysand.dao.IStudentRepo;
import top.tinysand.model.Student;

import java.util.List;

@Repository(value = "baseStudentRepo")
public class BaseStudentRepo
        extends BaseHibernateRepo<Student> implements IStudentRepo {

    @Override
    public boolean deleteStudent(Student student) {
        try {
            delete(student);
        } catch (Exception e) {
            return false;
        }
        return true;
    }



    @Override
    public boolean updateStudent(Student student) {
       try {
           update(student);
       } catch (Exception e) {
           return false;
       }
       return true;
    }

    @Override
    public boolean saveStudent(Student student) {
        try {
           save(student);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Student queryStudent(String studentId) {
        return get(Student.class, studentId);
    }

    @Override
    public List<Student> queryStudents() {
        return queryForList("from Student", null);
    }

}
