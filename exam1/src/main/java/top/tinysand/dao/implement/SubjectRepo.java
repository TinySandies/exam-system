package top.tinysand.dao.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.tinysand.model.Subject;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Supplier;

@Repository(value = "subjectRepo")
public class SubjectRepo {
    private JdbcTemplate jdbcTemplate;

    /*保存科目数据，对字符串转码，防止乱码*/
    public boolean saveSubject(Subject subject) throws Exception {
        return jdbcTemplate.update(saveSubject.get(),
                new String(subject.getSubjectName()
                        .getBytes("ISO8859-1"), StandardCharsets.UTF_8),
                new String(subject.getDescription()
                        .getBytes("ISO8859-1"), StandardCharsets.UTF_8),
                subject.getTestCount(), subject.getTotalScore(),
                subject.getTotalTime(), subject.getStatus()) > 0;
    }

    /*查询所有科目*/
    @SuppressWarnings("unchecked")
    public List<Subject> findAllSubjects() {
        return jdbcTemplate.query(selectAll.get(), new RowMapper());
    }

    /*数据映射类*/
    class RowMapper implements org.springframework.jdbc.core.RowMapper {

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            Subject subject = new Subject();
            subject.setSubId(resultSet.getInt("sub_id"));
            subject.setSubjectName(resultSet.getString("name"));
            subject.setDescription(resultSet.getString("description"));
            subject.setTestCount(resultSet.getInt("test_count"));
            subject.setTotalScore(resultSet.getDouble("total_score"));
            subject.setTotalTime(resultSet.getInt("total_time"));
            subject.setStatus(resultSet.getInt("status"));
            return subject;
        }
    }

    /*删除科目*/
    public boolean deleteSubject(Integer id) {
        return jdbcTemplate.update(deleteSubject.get(), id) > 0;
    }

    /*科目更新，对字符串进行转码，防止乱码*/
    public boolean updateSubject(Subject subject) throws Exception {
        return jdbcTemplate.update(updateSubject.get(),
                new String(subject.getSubjectName()
                        .getBytes("ISO8859-1"), StandardCharsets.UTF_8),
                new String(subject.getDescription()
                        .getBytes("ISO8859-1"), StandardCharsets.UTF_8),
                subject.getTestCount(), subject.getTotalScore(),
                subject.getTotalTime(), subject.getStatus(), subject.getSubId()) > 0;
    }

    /*查询单个科目*/
    @SuppressWarnings("unchecked")
    public Subject findSubjectById(Integer subjectId) {
        return (Subject) jdbcTemplate.queryForObject
                (seleteOne.get(), new RowMapper(), subjectId);
    }

    @Autowired
    public SubjectRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Supplier<String> selectAll = () -> "select * from exam_subject";

    private Supplier<String> saveSubject = () -> "insert into exam_subject" +
            "(name, description, test_count, total_score, total_time, status)" +
            " values (?,?,?,?,?,?)";

    private Supplier<String> updateSubject = () -> "update exam_subject " +
            "set name = ?, description = ?, test_count = ?, total_score = ?, " +
            "total_time = ?, status = ? where sub_id = ?";

    private Supplier<String> seleteOne =
            () -> "select * from exam_subject where sub_id = ?";

    private Supplier<String> deleteSubject =
            () -> "delete from exam_subject where sub_id = ?";

}
