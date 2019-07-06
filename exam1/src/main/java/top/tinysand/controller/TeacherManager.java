package top.tinysand.controller;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.tinysand.model.vo.SubjectVo;
import top.tinysand.service.implement.TeacherService;

import java.util.*;

@Controller(value = "teacherManager") @NoArgsConstructor
@RequestMapping(value = "/teacher")
public class TeacherManager {

    @RequestMapping(value = "/subjects")
    public String listAllSubjects(Model model) {
        List<SubjectVo> subjectList = teacherService.getAllSubjects();
        model.addAttribute("subjects", subjectList);
        return "subject/subject";
    }

    @ResponseBody
    @RequestMapping(value = "/getAllStudent")
    public Map<String, Object> getAllStudents(Integer subjectId) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("allUser", teacherService.getAllStudents());
        resultMap.put("selectedUser", teacherService.getAllUserBySubjectId(subjectId));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/saveSubjectStudents")
    public Map<String, Object> saveSubjectStudent(@RequestParam("subjectId") Integer subjectId,
                                                  @RequestParam("subjectStudents[]") String[] subjectStudents) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("success", false);

        List<String> list = new ArrayList<>();
        for (String student : subjectStudents) {
            list.add(student);
        }

        try {
            teacherService.saveSubjectStudents(list, subjectId);
            resultMap.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    @Autowired
    public TeacherManager(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    private TeacherService teacherService;
}
