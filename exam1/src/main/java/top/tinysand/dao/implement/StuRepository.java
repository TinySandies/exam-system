package top.tinysand.dao.implement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import top.tinysand.model.Student;

import java.sql.*;
import java.util.List;
import java.util.function.Supplier;

@Repository("stuRepository")
public class StuRepository {
    /*查询所有学生*/
    public List<Student> findAllUsers() {
        return jdbcTemplate.query(getAllUsers.get(), new DataMapper());
    }

    /*数据映射类*/
    class DataMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setUserId(resultSet.getString("user_id"));
            student.setUserName(resultSet.getString("user_name"));
            student.setGender(resultSet.getInt("gender"));
            student.setEmail(resultSet.getString("email"));
            student.setBirthday(resultSet.getDate("birthday"));
            student.setTel(resultSet.getString("tel"));
            student.setAddress(resultSet.getString("address"));
            student.setPassword(resultSet.getString("password"));
            return student;
        }
    }

    /*查找单个学生*/
    public Student getUserById(String id) {
        return jdbcTemplate.queryForObject(selectOne.get(), new DataMapper(), id);
    }

    /*修改单个学生*/
    public boolean editUser(Student student) {
        return jdbcTemplate.update(updateUser.get(), student.getUserName(),
                student.getTel(), student.getEmail(),
                student.getAddress(), student.getBirthday(),
                student.getGender(), student.getPassword(), student.getUserId()) > 0;
    }

    /*保存一个学生*/
    public boolean createUser(Student student) {
        return (jdbcTemplate.update(addUser.get(), student.getUserId(),
                student.getUserName(), student.getTel(),
                student.getEmail(), student.getAddress(),
                student.getBirthday(),
                student.getGender(), student.getPassword()) > 0);
    }

    /*删除要给学生*/
    public boolean deleteUser(String id) {
        return jdbcTemplate.update(deleteUser.get(), id) > 0;
    }

    @Autowired
    public StuRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    private Supplier<String> addUser = () -> "insert into exam_user" +
            "(user_id, user_name, tel, email, address, birthday, gender, password)" +
            " values (?, ?, ?, ?, ?, ?, ?, ?)";

    private Supplier<String> deleteUser =
            () -> "delete from exam_user where user_id = ?";

    private Supplier<String> updateUser =
            () -> "update exam_user set user_name = ?, tel = ?, " +
                    "email = ?, address = ?, birthday = ?, " +
                    "gender = ?, password = ? where user_id = ?";

    private Supplier<String> getAllUsers = () -> "select * from exam_user";

    private Supplier<String> selectOne =
            () -> "select *from exam_user where user_id = ?";

}
