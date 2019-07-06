package top.tinysand.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.tinysand.dao.implement.*;
import top.tinysand.model.ExamTest;
import top.tinysand.model.Student;

import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StuRepoTest {
    @Test
    public void findAllUsersTest() {
        List<Student> allUsers = stuRepository.findAllUsers();
        allUsers.forEach(System.out::println);
    }

    @Test
    public void findUserByIdTest() {
        System.out.println(stuRepository.getUserById("stu2"));
    }

    @Test
    public void createUserTest() throws Exception {
        Student student = new Student();
        student.setUserId("stu3000");
        student.setUserName("tiny");
        student.setPassword("2343434");
        student.setTel("15262714502");
        student.setEmail("2805363696@qq.com");
        student.setAddress("hongkong");
        student.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1999-09-11"));
        student.setGender(1);
        System.out.println(student);
//        stuRepository.createUser(student);
//        studentRepo.saveModel(student);
        stuHibernateRepo.saveStudent(student);
    }

    @Test
    public void editUserTest() throws Exception {
        Student student = new Student();
        student.setUserId("student44");
        student.setUserName("tinysand");
        student.setPassword("2343434");
        student.setTel("15262714502");
        student.setEmail("2805363696@qq.com");
        student.setAddress("shanghai");
        student.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1999-09-11"));
        student.setGender(1);
        stuHibernateRepo.saveStudent(student);
    }

    @Test
    public void deleteUserTest() {
        stuRepository.deleteUser("stu3");
    }

    @Before
    public void prepared() {
        /*加载Hibernate配置*/
        Configuration configuration = new Configuration().configure();
        /*准备会话工厂*/
        sessionFactory = configuration.buildSessionFactory();
    }

    @Test
    public void hibernateSaveTest() {

        /*获取Hibernate会话*/
        Session session = sessionFactory.openSession();
        /*开启Hibernate事务*/
        transaction = session.beginTransaction();

        ExamTest examTest = new ExamTest();
        examTest.setAnswer("D");
        examTest.setChooseA("12");
        examTest.setChooseB("16");
        examTest.setChooseC("32");
        examTest.setChooseD("72");
        examTest.setContent("intellij idea");
        examTest.setSubId(5);
//        examTest.setTestTypeId(3);

        /*持久化数据并提交事务*/
        session.save(examTest);
        transaction.commit();
    }

    @Test
    public void hibernateUpdateTest() {
        /*获取Hibernate会话*/
        Session session = sessionFactory.openSession();
        /*开启Hibernate事务*/
        transaction = session.beginTransaction();

        ExamTest examTest = new ExamTest();
        examTest.setId(27);
        examTest.setAnswer("D");
        examTest.setChooseA("12");
        examTest.setChooseB("16");
        examTest.setChooseC("32");
        examTest.setChooseD("72");
        examTest.setContent("tinysand");
        examTest.setSubId(5);
//        examTest.setTestTypeId(3);

        /*持久化数据并提交事务*/
        session.update(examTest);
        transaction.commit();
    }

    @Test
    public void hibernateDeletionTest() {
        /*获取Hibernate会话*/
        Session session = sessionFactory.openSession();
        /*开启Hibernate事务*/
        transaction = session.beginTransaction();
        ExamTest examTest = new ExamTest();
        examTest.setId(28);

        /*持久化数据并提交事务*/
        session.delete(examTest);
        transaction.commit();
    }

    @Test
    public void hibernateQueryTest() {
        /*获取Hibernate会话*/
        Session session = sessionFactory.openSession();
        /*开启Hibernate事务*/
        transaction = session.beginTransaction();

        /*持久化数据并提交事务*/
        ExamTest examTest = session.get(ExamTest.class, 27);

        System.out.println(examTest);
        transaction.commit();
    }

    /*BaseHibernate数据保存测试*/
//    @Test
//    public void saveModelTest() {
//        ExamTest examTest = new ExamTest();
//        examTest.setAnswer("D");
//        examTest.setChooseA("12");
//        examTest.setChooseB("16");
//        examTest.setChooseC("32");
//        examTest.setChooseD("72");
//        examTest.setContent("2 * 4 = ?");
//        examTest.setSubId(5);
////        examTest.setTestTypeId(3);
//        overrideRepo.saveModel(examTest);
//    }

    /*BaseHibernate数据更新测试*/
//    @Test
//    public void updateModelTest() {
//        ExamTest examTest = new ExamTest();
//        examTest.setId(29);
//        examTest.setAnswer("D");
//        examTest.setChooseA("12");
//        examTest.setChooseB("16");
//        examTest.setChooseC("32");
//        examTest.setChooseD("72");
//        examTest.setContent("tinysand");
//        examTest.setSubId(5);
////        examTest.setTestTypeId(3);
//        overrideRepo.updateModel(examTest);
//    }

    /*BaseHibernate数据删除测试*/
//    @Test
//    public void deleteModelTest() {
//        ExamTest examTest = new ExamTest();
//        examTest.setId(29);
//        overrideRepo.deleteModel(examTest);
//    }

    /*BaseHibernate单条数据查询测试*/
//    @Test
//    public void queryRecordTest() {
//        System.out.println(overrideRepo.queryRecord(31));
//    }

    /*BaseHibernate多条数据查询测试*/
//    @Test
//    public void queryRecordsTest() {
//        overrideRepo.queryRecords().forEach(System.out::println);
//    }

    /*Hibernate多表数据查询*/
    @SuppressWarnings("unchecked")
    @Test
    public void multiTableQueryTest() {
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.createQuery("from ExamTest")
                .list().forEach(System.out::println);
        transaction.commit();

    }

    /*Hibernate多表数据查询*/
    @SuppressWarnings("unchecked")
    @Test
    public void queryStudentsTest() {
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.createQuery("from Student ")
                .list().forEach(System.out::println);

        transaction.commit();
    }

    /*Hibernate学生单条数据查询*/
//    @Test
//    public void queryStudentTest() {
//        System.out.println(studentRepo.queryStudent("stu2"));
//    }

    /*Hibernate学生多条数据查询*/
//    @Test
//    public void queryAllStudentsTest() {
//        studentRepo.queryStudents().forEach(System.out::println);
//    }

    /*Hibernate查询单条科目记录*/
//    @Test
//    public void querySubjectTest() {
//        System.out.println(hSubjectRepo.querySubject(2));
//    }

    /*Hibernate查询多条科目记录*/
//    @Test
//    public void querySubjectsTest() {
//        hSubjectRepo.querySubjects().forEach(System.out::println);
//    }

    private static Transaction transaction;
    private static SessionFactory sessionFactory;

//    @Autowired
//    HSubjectRepo hSubjectRepo;

//    @Autowired
//    BaseStudentRepo studentRepo;

    @Autowired
    StuRepository stuRepository;

//    @Autowired
//    OverrideRepo overrideRepo;

    @Autowired
    StuHibernateRepo stuHibernateRepo;
}
