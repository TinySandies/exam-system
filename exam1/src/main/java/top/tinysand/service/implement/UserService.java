//package top.tinysand.service.implement;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import top.tinysand.dao.IUserDao;
//import top.tinysand.dao.implement.StuRepository;
//import top.tinysand.model.Student;
//import top.tinysand.service.IUserService;
//
//import java.util.List;
//
////@Service("stuService")
//public class UserService implements IUserService {
//    @Override
//    public List<Student> findAll() {
//        return stuRepository.findAll();
//    }
//
//    @Override
//    public Student getUserById(String id) {
//        return stuRepository.getUserById(id);
//    }
//
//    @Autowired
//    public UserService(StuRepository stuRepository) {
//        this.stuRepository = stuRepository;
//    }
//    @Override
//    public void add(Student user) throws Exception {
//        stuRepository.createUser(user);
//    }
//    @Override
//    public void editUser(Student user) throws Exception {
//        stuRepository.editUser(user);
//    }
//
//    @Override
//    public void deleteUser(String id) throws Exception {
//        stuRepository.deleteUser(id);
//    }
//
//    private StuRepository stuRepository;
//}
