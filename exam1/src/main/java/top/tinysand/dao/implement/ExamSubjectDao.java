package top.tinysand.dao.implement;

import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import top.tinysand.model.Subject;

import java.util.List;

@Repository(value = "examSubjectDao")
public class ExamSubjectDao extends BaseHibernateRepo<Subject> {
    public List<Subject> getAll() {
        return loadAll();
    }

    public void saveSubject(Subject subject) {
        this.save(subject);
    }

    @SuppressWarnings("unchecked")
    public List<String> getAllUserBySubjectId(Integer subjectId) {
        String sql = "select user.user_id as userId " + " from exam_user_subject eus " +
                " left join exam_subject es on eus.sub_id = es.sub_id " +
                " left join exam_user user on user.user_id = eus.user_id " +
                " where es.sub_id = :subjectId ";
        return this.createSqlQuery(sql)
                .addScalar("userId", StringType.INSTANCE)
                .setInteger("subjectId", subjectId)
                .list();
    }

    @Transactional
    public void insertSubjectUsers(List<String> insertList, Integer subjectId) {
        for (String userId : insertList) {
            String sql = "insert into exam_user_subject(user_id, sub_id) values(:userId, :subjectId)";
            createSqlQuery(sql).setString("userId", userId)
                    .setInteger("subjectId", subjectId).executeUpdate();
        }
    }

    @Transactional
    public void deleteSubjectUsers(List<String> deleteList, Integer subjectId) {
        for (String userId : deleteList) {
            String sql = "delete exam_user_subject from exam_user_subject where user_id = :userId and sub_id = :subjectId";
            createSqlQuery(sql).setString("userId", userId)
                    .setInteger("subjectId", subjectId).executeUpdate();
        }
    }
}
