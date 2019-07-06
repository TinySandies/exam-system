package top.tinysand.exam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.tinysand.dao.repository.SubjectRepo;
import top.tinysand.model.Subject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SubjectTest {
    @Test // 使用Hibernate查询一条科目
    public void testQuerySubject() {
        System.out.println(subjectRepo.querySubject(2));
    }

    @Test // 使用Hibernate查询所有科目
    public void testQueryAllSubjects() {
        subjectRepo.queryAllSubjects().forEach(System.out::println);
    }

    @Test // 使用Hibernate更新一条科目
    public void testUpdateSubject() {
        Subject subject = new Subject();
        subject.setSubId(6);
        subject.setSubjectName("大学计算机科学");
        subject.setDescription("大学计算机科学");
        subject.setTotalTime(23);
        subject.setTotalScore(90.0);
        subject.setStatus(0);
        subject.setTestCount(34);
        subjectRepo.updateSubject(subject);
    }

    @Test // 使用Hibernate删除一条科目
    public void testDeleteSubject() {
        Subject subject = new Subject();
        subject.setSubId(6);
//        subject.setName("大学英语");
//        subject.setDescription("大学英语第二学期");
//        subject.setTotalTime(23);
//        subject.setTotalScore(90.0);
//        subject.setStatus(0);
//        subject.setTestCount(34);
        subjectRepo.deleteSubject(subject);
    }

    @Test // 使用Hibernate保存一条科目
    public void testSaveSubject() {
        Subject subject = new Subject();
//        subject.setSubId();
        subject.setSubjectName("大学英语");
        subject.setDescription("大学英语第二学期");
        subject.setTotalTime(23);
        subject.setTotalScore(90.0);
        subject.setStatus(0);
        subject.setTestCount(34);
        subjectRepo.saveSubject(subject);
    }

    @Autowired
    SubjectRepo subjectRepo;
}

