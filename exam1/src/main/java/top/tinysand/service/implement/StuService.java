package top.tinysand.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tinysand.dao.implement.StuRepository;
import top.tinysand.model.Student;

import java.util.List;

@Service
public class StuService{
    public List<Student> findAll() {
        return stuRepository.findAllUsers();
    }

    public Student findById(String id) {
        return stuRepository.getUserById(id);
    }

    @Autowired
    public StuService(StuRepository stuRepository) {
        this.stuRepository = stuRepository;
    }
    public boolean add(Student user) {
        return stuRepository.createUser(user);
    }
    public boolean edit(Student user) {
        return stuRepository.editUser(user);
    }

    public boolean delete(String id) {
        return stuRepository.deleteUser(id);
    }

    private StuRepository stuRepository;
}
