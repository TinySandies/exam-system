package top.tinysand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.tinysand.dao.implement.UserRoleRepo;
import top.tinysand.dao.repository.StudentRepo;
import top.tinysand.model.Student;
import top.tinysand.model.UserRole;
import top.tinysand.model.vo.UserVo;
//import top.tinysand.util.ExcelUtils;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;

@Controller
public class LoginManager {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("userVo", new UserVo());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Validated UserVo userVo, BindingResult bindingResult,
                        HttpSession session, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/login";
        } else if (!bindingResult.hasErrors() && userVo != null) {
            Student student = studentRepo.queryStudent(userVo.getUserId()); //根据用户ID查询用户完整信息
            if (student != null) {
                String password = userVo.getPassword();
                Calendar instance = Calendar.getInstance();
                instance.setTime(new Date());
                instance.add(Calendar.MINUTE, -5); //当前时间减去五分钟

                if (student.getLastLockTime().before(instance.getTime())) { //当前时间距离上次锁定时间过了三分钟
                    if (password.equals(student.getPassword())) { //密码正确
                        student.setLoginFailCount(0);
                        studentRepo.updateStudent(student); //登录成功，用户登录失败次数置零
                        session.setAttribute("examUser", student); //session保存当前登录用户，便于其他地方获取用户信息
                        redirectAttributes.addFlashAttribute("message", "登录成功"); //添加操作信息

                        // 获取用户角色信息
                        UserRole userRole = userRoleRepo.getUserRoleById(student.getUserId());
                        if (userRole.getRoleId().equals(ROLE_STUDENT)) {
                            session.setAttribute("role", "student");
                            return "redirect:/student/exams"; // 角色是学生，跳转到试题列表页面
                        } else if (userRole.getRoleId().equals(ROLE_TEACHER)) {
                            session.setAttribute("role", "teacher");
                            return "redirect:/teacher/exams"; // 角色是老师，跳转到试题管理页面
                        }
                    } else { // 密码不正确
                        student.setLoginFailCount(student.getLoginFailCount() + 1); //失败次数 + 1
                        if (student.getLoginFailCount() == 3) { //失败三次，更新锁定时间
                            student.setLoginFailCount(0);
                            student.setLastLockTime(new Date());
                            studentRepo.updateStudent(student);
                        }
                        redirectAttributes.addFlashAttribute("message", "用户ID或密码错误，登录失败");
                        studentRepo.updateStudent(student);
                    }
                } else {
                    redirectAttributes.addFlashAttribute("message", "登录失败，请于五分钟后重试");
                }
            }
        }
        return "redirect:/login"; //登录失败，重定向到登录页面
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) { // 退出登录
        session.removeAttribute("examUser");
        return "redirect:/login";
    }

    @Autowired
    public LoginManager(StudentRepo studentRepo, UserRoleRepo userRoleRepo) {
        this.studentRepo = studentRepo;
        this.userRoleRepo = userRoleRepo;
    }

    private StudentRepo studentRepo;
    private UserRoleRepo userRoleRepo;

    private static final Integer ROLE_STUDENT = 25;
    private static final Integer ROLE_TEACHER = 26;
}
