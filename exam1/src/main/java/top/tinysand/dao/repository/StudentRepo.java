package top.tinysand.dao.repository;

import org.springframework.stereotype.Repository;
import top.tinysand.dao.AbstractRepository;
import top.tinysand.model.Student;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Repository(value = "studentRepo")
public class StudentRepo extends AbstractRepository {
    private Student convertCode(Student student) { //中文乱码处理
        try {
            student.setUserId(new String(student.getUserId()
                    .getBytes(ISO8859_1), StandardCharsets.UTF_8));
            student.setAddress(new String(student.getAddress()
                    .getBytes(ISO8859_1), StandardCharsets.UTF_8));
            student.setEmail(new String(student.getEmail()
                    .getBytes(ISO8859_1), StandardCharsets.UTF_8));
            student.setTel(new String(student.getTel()
                    .getBytes(ISO8859_1), StandardCharsets.UTF_8));
            student.setPassword(new String(student.getPassword()
                    .getBytes(ISO8859_1), StandardCharsets.UTF_8));
            student.setUserName(new String(student.getUserName()
                    .getBytes(ISO8859_1), StandardCharsets.UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return student;
    }

    public boolean saveStudent(Student student) {   //保存实体
        System.out.println("save student ......");
        hibernateDML(session -> session.save(convertCode(student)));
        System.out.println("student saved" + student);
        return true;
    }

    public boolean updateStudent(Student student) { //更新实体
        hibernateDML(session -> session.update(convertCode(student)));
        return true;
    }

    public boolean deleteStudent(Student student) { //根据实体删除数据
        hibernateDML(session -> session.delete(student));
        return true;
    }

    public Student queryStudent(String id) {    //根据主键查询一条数据
        return hibernateDQL(session -> session.get(Student.class, id));
    }

    @SuppressWarnings(value = "unchecked")
    public List<Student> queryStudents() { //根据类型查询多条数据
        return hibernateDQL(session -> session.createQuery(
                "from Student"
        ).list());
    }

    private static final String ISO8859_1 = "ISO8859-1";
}
