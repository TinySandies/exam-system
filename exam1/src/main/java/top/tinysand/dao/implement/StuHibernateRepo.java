package top.tinysand.dao.implement;

import org.springframework.stereotype.Repository;
import top.tinysand.dao.AbstractRepository;
import top.tinysand.model.Student;

import java.util.List;

@Repository(value = "stuHibernateRepos")
public class StuHibernateRepo extends AbstractRepository {
    /*保存实体*/
    public boolean saveStudent(Student student) {
        hibernateDML(session -> session.save(student));
        return true;
    }

    /*更新实体*/
    public boolean updateStudent(Student student) {
        hibernateDML(session -> session.update(student));
        return true;
    }

    /*根据实体删除数据*/
    public boolean deleteStudent(Student student) {
        hibernateDML(session -> session.delete(student));
        return true;
    }

    /*根据主键查询一条数据*/
    public Student queryStudent(String id) {
        return hibernateDQL(session -> session.get(Student.class, id));
    }

    /*根据类型查询多条数据*/
    @SuppressWarnings(value = "unchecked")
    public List<Student> queryStudents() {
        return hibernateDQL(session -> session.createQuery(
                "from Student"
        ).list());
    }
}
