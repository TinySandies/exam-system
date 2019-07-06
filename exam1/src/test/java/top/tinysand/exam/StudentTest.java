package top.tinysand.exam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.tinysand.dao.implement.BaseStudentRepo;
import top.tinysand.dao.repository.StudentRepo;
import top.tinysand.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentTest {
    @Test //用Hibernate查询一个实体
    public void testQueryStudent() {
        System.out.println(studentRepo.queryStudent("hahaha123"));
    }

    @Test // 用Hibernate查询所有实体
    public void testQueryAllStudents() {
        studentRepo.queryStudents().forEach(System.out::println);
    }

    @Test // 用Hibernate更新实体
    public void testUpdateStudent() throws ParseException {
        Student student = new Student();
        student.setUserId("stu3000");
        student.setUserName("tinysand");
        student.setPassword("2343434");
        student.setTel("15262714502");
        student.setEmail("2805363696@qq.com");
        student.setAddress("hongkong");
        student.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1999-09-11"));
        student.setGender(1);
        studentRepo.updateStudent(student);
    }

    @Test // 用Hibernate删除实体
    public void testDeleteStudent() {
        Student student = new Student();
        student.setUserId("stu3000");
        studentRepo.deleteStudent(student);
    }

    @Test // 用Hibernate保存实体
    public void testSaveStudent()  throws ParseException{
        Student student = new Student();
        student.setUserId("stu3000");
        student.setUserName("tiny");
        student.setPassword("2343434");
        student.setTel("15262714502");
        student.setEmail("2805363696@qq.com");
        student.setAddress("hongkong");
        student.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1999-09-11"));
        student.setGender(1);
        assert studentRepo.saveStudent(student);
    }

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    BaseStudentRepo baseStudentRepo;
}

