package top.tinysand.dao.implement;

import org.springframework.stereotype.Repository;
import top.tinysand.dao.IUserDao;
import top.tinysand.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

//@Repository("userDao")
public class UserDao implements IUserDao {
    private static Map<String, Student> students = new HashMap<>();

    @Override
    public List<Student> findAll() {
        try {
            return this.queryData(sql, resultSet -> {
                List<Student> students = new ArrayList<>();
                try {
                    while (resultSet.next()) {
                        Student student = new Student();
                        student.setUserId(resultSet.getString(1));
                        student.setUserName(resultSet.getString(2));
                        student.setGender(resultSet.getInt(3));
                        student.setBirthday(resultSet.getDate(4));
                        student.setTel(resultSet.getString(5));
                        student.setAddress(resultSet.getString(6));

                        students.add(student);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return students;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private <R> R queryData(String selectAll, Function<ResultSet, R> processor,
                            Object... fillParams)
            throws Exception {
        Class.forName(driver);
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectAll);
            for (int index = 0; index < fillParams.length; index++)
                preparedStatement.setObject(index, fillParams[index - 1]);

            return processor.apply(preparedStatement.executeQuery());
        }
    }

    @Override
    public Student findById(String id) {
        return students.get(id);
    }

    @Override
    public void edit(Student student) throws Exception {
        if (student != null && students.containsKey(student.getUserId())) {
            students.put(student.getUserId(), student);
        } else {
            throw new Exception("修改失败！");
        }
    }

    public void addUser(Student student) throws Exception {
        if (student != null && !students.containsKey(student.getUserId())) {
            students.put(student.getUserId(), student);
        } else {
            throw new Exception("添加失败！");
        }
    }

    @Override
    public void delete(String id) throws Exception {
        if (students.containsKey(id)) {
            students.remove(id);
        } else {
            throw new Exception("删除失败!");
        }
    }

    private static final String url = "jdbc:mysql://localhost:3306/exam?characterEncoding=utf8" +
            "&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";

    private static final String user = "root";
    private static final String password = "tiny";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    private static final String sql = "select user_id, user_name, gender, birthday," +
            " tel, address from exam_user";

}
