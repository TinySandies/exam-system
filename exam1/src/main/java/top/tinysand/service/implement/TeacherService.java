package top.tinysand.service.implement;

import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tinysand.dao.implement.ExamSubjectDao;
import top.tinysand.dao.implement.StudentDao;
import top.tinysand.model.Student;
import top.tinysand.model.Subject;
import top.tinysand.model.vo.StudentVo;
import top.tinysand.model.vo.SubjectVo;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
@Service(value = "teacherService") @NoArgsConstructor
public class TeacherService {
    public List<SubjectVo> getAllSubjects() { // 获取所有科目
        List<Subject> subjects = examSubjectDao.getAll();
        List<SubjectVo> subjectVos = new ArrayList<>();
        for (Subject subject : subjects) {
            SubjectVo subjectVo = new SubjectVo();
            BeanUtils.copyProperties(subject, subjectVo);
            subjectVos.add(subjectVo);
        }
        return subjectVos;
    }

    public List<StudentVo> getAllStudents() { // 获取所有学生
        List<Student> students = studentDao.getAllStudents();
        List<StudentVo> studentVos = new ArrayList<>();
        for (Student student : students) {
            StudentVo studentVo = new StudentVo();
            BeanUtils.copyProperties(student, studentVo);
            studentVos.add(studentVo);
        }
        return studentVos;
    }

    //根据科目ID获取学生
    public List<String> getAllUserBySubjectId(Integer subjectId) {
        return examSubjectDao.getAllUserBySubjectId(subjectId);
    }

    public void saveSubject(SubjectVo subjectVo) { // 保存科目
        Subject subject = new Subject();
        BeanUtils.copyProperties(subjectVo, subject);
        examSubjectDao.save(subject);
    }

    //更新学生科目信息
    public void saveSubjectStudents(List<String> students, Integer subjectId) {
        List<String> subjectUsers = examSubjectDao.getAllUserBySubjectId(subjectId);
        List<String> insertList = new ArrayList<>();
        List<String> deleteList = new ArrayList<>();
        for (String selectedUser : students) {
            if (!subjectUsers.contains(selectedUser))
                insertList.add(selectedUser);
        }

        for (String selectedUser : subjectUsers) {
            if (!students.contains(selectedUser))
                deleteList.add(selectedUser);
        }

        examSubjectDao.insertSubjectUsers(insertList, subjectId);
        examSubjectDao.deleteSubjectUsers(deleteList, subjectId);
    }

    @Autowired
    public TeacherService(ExamSubjectDao examSubjectDao, StudentDao studentDao) {
        this.examSubjectDao = examSubjectDao;
        this.studentDao = studentDao;
    }

    private ExamSubjectDao examSubjectDao;
    private StudentDao studentDao;
}
