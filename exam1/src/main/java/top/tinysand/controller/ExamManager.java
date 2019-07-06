package top.tinysand.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.tinysand.dao.repository.ExamTestTypeRepo;
import top.tinysand.dao.repository.SubjectRepo;
import top.tinysand.model.ExamTestType;
import top.tinysand.model.Subject;
import top.tinysand.model.vo.ExamTestTypeVo;
import top.tinysand.model.vo.ExamVo;
import top.tinysand.model.vo.ResultMessage;
import top.tinysand.model.vo.SubjectVo;
import top.tinysand.service.implement.ExamService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/teacher")
public class ExamManager {
    @RequestMapping(value = "/exams", method = RequestMethod.GET)
    public String listAllExam(Model model) { //查询所有试题
        List<ExamVo> allExams = examService.getAllExams();
        model.addAttribute("allExam", allExams);
        return "exam/exam";
    }

    @ResponseBody
    @RequestMapping(value = "/getTestById", method = RequestMethod.POST)
    public ExamVo getExamById(Integer testId) { //查询一个试题
        return examService.getExamById(testId);
    }

    @ResponseBody
    @RequestMapping(value = "/saveTest", method = RequestMethod.POST)
    public ResultMessage saveExamTest
            (ExamVo examVo, BindingResult bindingResult) { //保存试题
        ResultMessage resultMessage = new ResultMessage();
        Map<String, String> messageMap = new HashMap<>();

        dataValidation(resultMessage, messageMap, bindingResult);
        try {
            examService.saveExamTest(examVo);
            resultMessage.setSuccess(true);
        } catch (Exception e) {
            messageMap.put("message", e.getMessage());
            resultMessage.setMessageMap(messageMap);
        }
        return resultMessage;
    }

    private void dataValidation // 数据校验
            (ResultMessage resultMessage,
             Map<String, String> messageMap, BindingResult bindingResult) {
        resultMessage.setSuccess(false);
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                FieldError fieldError = (FieldError) error;
                messageMap.put(fieldError.getField(),
                        fieldError.getDefaultMessage());
            }
            resultMessage.setMessageMap(messageMap);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/editTest", method = RequestMethod.POST)
    public ResultMessage editExamTest
            (ExamVo examVo, BindingResult bindingResult) { // 修改试题
        ResultMessage resultMessage = new ResultMessage();
        Map<String, String> messageMap = new HashMap<>();
        dataValidation(resultMessage, messageMap, bindingResult);
        try {
            examService.editExamTest(examVo);
            resultMessage.setSuccess(true);
        } catch (Exception e) {
            messageMap.put("message", e.getMessage());
            resultMessage.setMessageMap(messageMap);
        }
        return resultMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteTest", method = RequestMethod.POST)
    public ResultMessage deleteExamTest(Integer examId) { //删除试题
        ResultMessage resultMessage = new ResultMessage();
        Map<String, String> messageMap = new HashMap<>();
        resultMessage.setSuccess(false);
        try {
            examService.deleteExamTest(examId);
            resultMessage.setSuccess(true);
        } catch (Exception e) {
            messageMap.put("message", e.getMessage());
            resultMessage.setMessageMap(messageMap);
        }
        return resultMessage;
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
    public ExamManager(ExamService examService, SubjectRepo subjectRepo,
                       ExamTestTypeRepo examTestTypeRepo) {
        this.examService = examService;
        this.examTestTypeRepo = examTestTypeRepo;
        this.subjectRepo = subjectRepo;
    }
}
