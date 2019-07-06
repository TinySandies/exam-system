package top.tinysand.service.implement;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tinysand.dao.implement.BaseStudentRepo;
import top.tinysand.dao.repository.StudentRepo;
import top.tinysand.model.Student;
import top.tinysand.model.vo.StudentVo;
import top.tinysand.util.ExcelUtils;

import java.io.InputStream;
import java.util.List;

@Service(value = "studentService")
public class StudentService {
    public List<Student> findAll() {
        return studentRepo.queryStudents();
    }

    public Student findById(String id) {
        return studentRepo.queryStudent(id);
    }

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public boolean add(Student user) {
        return studentRepo.saveStudent(user);
    }
    public boolean edit(Student user) {
        return studentRepo.updateStudent(user);
    }

    public boolean delete(String id) {
        Student student = new Student();
        student.setUserId(id);
        return studentRepo.deleteStudent(student);
    }

    //导入excel表学生数据
    public void saveStudentByExcel(InputStream inputStream, String postfix) {
        Workbook workbook = ExcelUtils.openWorkbook(inputStream, postfix);
        List<StudentVo> excelStudents = ExcelUtils.getStudentsByExcel(workbook);
        if (excelStudents != null) {
            Student student;
            for (StudentVo excelStudent : excelStudents) {
                student = new Student();
                BeanUtils.copyProperties(excelStudent, student);
                studentRepo.saveStudent(student);
            }
        }
    }

    private StudentRepo studentRepo;
}
