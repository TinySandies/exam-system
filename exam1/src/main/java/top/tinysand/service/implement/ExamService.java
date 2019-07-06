package top.tinysand.service.implement;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tinysand.dao.repository.ExamTestRepo;
import top.tinysand.dao.repository.SubjectRepo;
import top.tinysand.model.ExamTest;
import top.tinysand.model.ExamTestType;
import top.tinysand.model.vo.ExamVo;

import java.util.ArrayList;
import java.util.List;

@Service(value = "examService")
public class ExamService {
    public List<ExamVo> getAllExams() {          //查询所有试题
        List<ExamVo> examVos = new ArrayList<>();
        List<ExamTest> allExamTest = examTestRepo.queryAllExamTest();
        allExamTest.forEach(examTest -> {
            ExamVo examVo = new ExamVo();
            BeanUtils.copyProperties(examTest.getExamTestType(), examVo);

            BeanUtils.copyProperties(examTest, examVo);
            examVo.setSubjectName(subjectRepo.querySubject
                    (examTest.getSubId()).getSubjectName());
             examVos.add(examVo);
        });
        return examVos;
    }

    public ExamVo getExamById(Integer examId) {   //获取一个试题
        ExamVo examVo = new ExamVo();
        ExamTest examTest = examTestRepo.queryExamTest(examId);
        BeanUtils.copyProperties(examTest, examVo);
        BeanUtils.copyProperties(subjectRepo.querySubject(examTest.getSubId()), examVo);
        BeanUtils.copyProperties(examTest.getExamTestType(), examVo);
        return examVo;
    }


    public void saveExamTest(ExamVo examVo) {     //保存试题
        ExamTest examTest = new ExamTest();
        BeanUtils.copyProperties(examVo, examTest);

        ExamTestType examTestType = new ExamTestType();
        examTestType.setId(Integer.valueOf(examVo.getTestType()));
        examTest.setExamTestType(examTestType);

        examTestRepo.saveExamTest(examTest);
    }

    public void deleteExamTest(Integer examId) {  //删除试题
        ExamTest examTest = new ExamTest();
        examTest.setId(examId);
        examTestRepo.deleteExamTest(examTest);
    }

    public void editExamTest(ExamVo examVo) {     //修改试题
        ExamTest examTest = new ExamTest();
        BeanUtils.copyProperties(examVo, examTest);

        ExamTestType examTestType = new ExamTestType();
        examTestType.setId(Integer.valueOf(examVo.getTestType()));
        examTest.setExamTestType(examTestType);

        examTestRepo.updateExamTest(examTest);
    }

    private ExamTestRepo examTestRepo;
    private SubjectRepo subjectRepo;

    @Autowired
    public ExamService(ExamTestRepo examTestRepo, SubjectRepo subjectRepo) {
        this.examTestRepo = examTestRepo;
        this.subjectRepo = subjectRepo;
    }
}
