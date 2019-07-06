package top.tinysand.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.tinysand.dao.repository.ExamTestTypeRepo;
import top.tinysand.dao.repository.SubjectRepo;
import top.tinysand.model.ExamTestType;
import top.tinysand.model.Subject;
import top.tinysand.model.vo.ExamTestTypeVo;
import top.tinysand.model.vo.ExamVo;
import top.tinysand.model.vo.SubjectVo;
import top.tinysand.service.implement.ExamService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
@Controller
@RequestMapping(value = "/student")
public class StudentView {
    @RequestMapping(value = "/exams", method = RequestMethod.GET)
    public String listAllExam(Model model) { //查询所有试题
        List<ExamVo> allExams = examService.getAllExams();
        model.addAttribute("allExam", allExams);
        return "student/examView";
    }

    @ResponseBody
    @RequestMapping(value = "/getTestById", method = RequestMethod.POST)
    public ExamVo getExamById(Integer testId) { //查询一个试题
        return examService.getExamById(testId);
    }

    @ResponseBody
    @RequestMapping(value = "/getSubjectAndTypes", method = RequestMethod.POST)
    public Map<String, Object> getSubjectAndTypes() {  //获取科目与试题类型
        Map<String, Object> resultMap = new HashMap<>();

        List<ExamTestType> allExamTypes = examTestTypeRepo.queryAllExamTestType();
        List<Subject> subjects = subjectRepo.queryAllSubjects();

        List<ExamTestTypeVo> examTestTypeVos = new ArrayList<>();
        allExamTypes.forEach(examTestType -> {
            ExamTestTypeVo examTestTypeVo = new ExamTestTypeVo();
            BeanUtils.copyProperties(examTestType, examTestTypeVo);
            examTestTypeVos.add(examTestTypeVo);
        });

        List<SubjectVo> subjectVos = new ArrayList<>();
        subjects.forEach(subject -> {
            SubjectVo subjectVo = new SubjectVo();
            BeanUtils.copyProperties(subject, subjectVo);
            subjectVos.add(subjectVo);
        });
        resultMap.put("subjectList", subjectVos);
        resultMap.put("testTypeList", examTestTypeVos);
        return resultMap;
    }

    private ExamService examService;
    private SubjectRepo subjectRepo;
    private ExamTestTypeRepo examTestTypeRepo;

    @Autowired
    public StudentView(ExamService examService, SubjectRepo subjectRepo,
                       ExamTestTypeRepo examTestTypeRepo) {
        this.examService = examService;
        this.examTestTypeRepo = examTestTypeRepo;
        this.subjectRepo = subjectRepo;
    }
}
