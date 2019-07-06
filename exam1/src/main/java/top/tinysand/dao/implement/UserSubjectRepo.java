package top.tinysand.dao.implement;

import org.springframework.stereotype.Repository;
import top.tinysand.model.ExamUserSubject;

@Repository(value = "userSubjectRepo")
public class UserSubjectRepo extends BaseHibernateRepo<ExamUserSubject> {
    public ExamUserSubject getUserSubjectById(String userId) {
        return this.get(ExamUserSubject.class, userId);
    }
}
