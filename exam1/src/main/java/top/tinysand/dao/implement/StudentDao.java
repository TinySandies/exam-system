package top.tinysand.dao.implement;

import org.springframework.stereotype.Repository;
import top.tinysand.model.Student;

import java.util.List;

@Repository(value = "studentDao")
public class StudentDao extends BaseHibernateRepo<Student> {
    public List<Student> getAllStudents() {
//        loadAll().forEach(System.err::println);
        return queryForList("from Student", null);
    }
}
