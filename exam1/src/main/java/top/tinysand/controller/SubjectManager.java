package top.tinysand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.tinysand.model.Subject;
import top.tinysand.service.implement.SubjectService;

import java.util.function.Supplier;

@Controller
public class SubjectManager {
    private SubjectService subjectService;

    @Autowired
    public SubjectManager(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    /*科目列表展示请求*/
    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public String listAllSubjects(Model model) {
        model.addAttribute("subjects", subjectService.findAllSubjects());
        return "subject/subject";
    }

    /*科目添加请求*/
    @RequestMapping(value = "/subject/add", method = RequestMethod.GET)
    public String addSubject(Model model) {
        model.addAttribute("subject", new Subject());
        return "subject/addSubject";
    }

    /*科目添加数据提交*/
    @RequestMapping(value = "/subject/add", method = RequestMethod.POST)
    public String addSubject
            (Subject subject, RedirectAttributes redirectAttributes) {
        if (subject == null)
            return "subject/addSubject";

        boolean resultFlag;
        try {
            resultFlag = subjectService.saveSubject(subject);
        } catch (Exception e) {
            resultFlag = false;
        }

        redirectAttributes.addFlashAttribute
                ("subjectMessage", resultFlag ? addSuccess.get() : addFailed.get());
        return "redirect:/subjects";
    }

    /*科目修改请求*/
    @RequestMapping(value = "/subject/edit/{subId}", method = RequestMethod.GET)
    public String editSubject(@PathVariable String subId, Model model) {
        model.addAttribute("subject", subjectService
                .findSubjectById(Integer.valueOf(subId)));

        return "subject/editSubject";
    }

    /*科目修改提交*/
    @RequestMapping(value = "/subject/edit/{subId}", method = RequestMethod.POST)
    public String editSubject
            (RedirectAttributes redirectAttributes, Subject subject,
             @PathVariable String subId) {
        boolean resultFlag;
        subject.setSubId(Integer.valueOf(subId));
        try {
            resultFlag = subjectService.updateSubject(subject);
        } catch (Exception e) {
            resultFlag = false;
        }
        redirectAttributes.addFlashAttribute
                ("subjectMessage", resultFlag ? editSuccess.get() : editFailed.get());
        return "redirect:/subjects";
    }

    /*科目删除请求*/
    @RequestMapping(value = "/subject/delete/{subId}", method = RequestMethod.GET)
    public String deleteSubject
            (@PathVariable String subId, RedirectAttributes redirectAttributes) {
        boolean resultFlag;
        try {
            resultFlag = subjectService.deleteSubject(Integer.valueOf(subId));
        } catch (Exception e) {
            resultFlag = false;
        }
        redirectAttributes.addFlashAttribute
                ("subjectMessage", resultFlag ? deleteSuccess.get() : deleteFailed.get());
        return "redirect:/subjects";
    }

    private Supplier<String> addSuccess = () -> "添加成功！";
    private Supplier<String> addFailed = () -> "添加失败！";

    private Supplier<String> editSuccess = () -> "修改成功！";
    private Supplier<String> editFailed = () -> "修改失败！";

    private Supplier<String> deleteSuccess = () -> "删除成功！";
    private Supplier<String> deleteFailed = () -> "删除失败！";

}
