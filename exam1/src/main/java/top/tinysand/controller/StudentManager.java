package top.tinysand.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.tinysand.model.Student;
import top.tinysand.model.vo.ResultMessage;
import top.tinysand.service.implement.StudentService;
import top.tinysand.util.ExcelUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
public class StudentManager {
    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    /*用户列表展示*/
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        logger.info(LocaleContextHolder.getLocale().toString());

        model.addAttribute("users", studentService.findAll());
        return "user/userList";
    }

    @Autowired
    public StudentManager(StudentService studentService, LocaleResolver localeResolver) {
        this.studentService = studentService;
        this.localeResolver = localeResolver;
//        this.messageSource = messageSource;
    }

    /*跳转到添加用户页面*/
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        /*实例化一个User类对象给前台表单使用*/
        model.addAttribute("student", new Student());
        return "user/add";
    }

    /*添加用户的表单提交*/
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(RedirectAttributes redirectAttributes,
                      @Validated Student student, BindingResult bindingResult) {
        logger.info("enter the addition step");
        if (bindingResult.hasErrors()) {
            return "/user/add";
        }

        boolean resultFlag;
        try {
            resultFlag = studentService.add(student);
        } catch (Exception e) {
            resultFlag = false;
        }
        redirectAttributes.addFlashAttribute("message", resultFlag ? "添加成功" : "添加失败");
        return "redirect:users";
    }

    /*转向用户信息修改页面*/
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, Model model,
                       RedirectAttributes redirectAttributes) {
        Student userToEdit = studentService.findById(id);
        if (userToEdit != null) {
            model.addAttribute("user", userToEdit);
        } else {
            redirectAttributes.addFlashAttribute("message", "用户不存在！");
            return "user/userList";
        }

        return "user/edit";
    }

    /*用户信息修改页面表单提交*/
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Student user, RedirectAttributes redirectAttributes,
                       @PathVariable String id) {
        boolean resultFlag;
        try {
            user.setUserId(id);
            resultFlag = studentService.edit(user);
        } catch (Exception e) {
            resultFlag = false;
        }
        redirectAttributes.addFlashAttribute("message", resultFlag ? "修改成功" : "修改失败");
        return "redirect:/users";
    }

    /*根据ID删除用户信息*/
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id,
                         RedirectAttributes redirectAttributes) {
        logger.info("enter the deletion");
        redirectAttributes.addFlashAttribute
                ("message", studentService.delete(id) ? "删除成功" : "删除失败");
        return "redirect:/users";
    }

    /*页面语言切换*/
    @RequestMapping(value = "/switchLang", method = RequestMethod.GET)
    public String switchLang(HttpServletRequest request,
                             HttpServletResponse response, String localeType) {
        if ("en_US".equals(localeType)) {
            localeResolver.setLocale(request, response, Locale.ENGLISH);
//            Locale locale = new Locale("en", "US");
//            request.getSession().setAttribute
//                    (SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);

            logger.info("英文切换" + localeType);
        } else {
            localeResolver.setLocale(request, response, Locale.CHINESE);
//            Locale locale = new Locale("zh", "CN");
//            request.getSession().setAttribute
//                    (SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
            logger.info("中文切换" + localeType);
        }
        return "redirect:/users";
    }

    @RequestMapping(value = "/uploadFile")
    @ResponseBody
    public ResultMessage uploadFile
            (@RequestParam(value = "uploadFile") MultipartFile[] multipartFiles) {
        ResultMessage resultMessage = new ResultMessage();
        MultipartFile uploadFile = multipartFiles[0];
        String fileName = uploadFile.getOriginalFilename();

        String postfix = fileName.substring(fileName.lastIndexOf("."));
        Map<String, String> messageMap = new HashMap<>();

        try {
            if (ExcelUtils.OFFICE_EXCEL_2007_POSTFIX.equals(postfix) ||
                    ExcelUtils.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
                studentService.saveStudentByExcel(uploadFile.getInputStream(), postfix);
                resultMessage.setSuccess(true);
                messageMap.put("message", "批量插入学生成功");
                resultMessage.setMessageMap(messageMap);
            } else {
                System.out.println("文件格式不正确");
                messageMap.put("message", "文件格式不正确！");
                resultMessage.setMessageMap(messageMap);
            }
        } catch (Exception e) {
            messageMap.put("message", "批量导入学生失败！");
            resultMessage.setMessageMap(messageMap);
        }
        return resultMessage;
    }

    private final StudentService studentService;

    private final LocaleResolver localeResolver;

//    private final MessageSource messageSource;
}
