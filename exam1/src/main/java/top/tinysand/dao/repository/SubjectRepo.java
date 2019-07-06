package top.tinysand.dao.repository;

import org.springframework.stereotype.Repository;
import top.tinysand.dao.AbstractRepository;
import top.tinysand.model.Subject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Repository(value = "subjectRepository")
public class SubjectRepo extends AbstractRepository {
    public boolean saveSubject(Subject subject) {   //保存实体
        hibernateDML(session -> session.save(convertCode(subject)));
        return true;
    }

    public boolean updateSubject(Subject subject) { //更新实体
        hibernateDML(session -> session.update(convertCode(subject)));
        return true;
    }

    private Subject convertCode(Subject subject) {  //字符串中文乱码处理
        try {
            subject.setSubjectName(new String(subject.getSubjectName()
                    .getBytes(ISO8859_1), StandardCharsets.UTF_8));
            subject.setDescription(new String(subject.getDescription()
                    .getBytes(ISO8859_1), StandardCharsets.UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return subject;
    }

    public boolean deleteSubject(Subject subject) {  //根据实体删除科目数据
        hibernateDML(session -> session.delete(subject));
        return true;
    }

    public Subject querySubject(Integer id) {        //根据主键查询一条科目
        return hibernateDQL(session -> session.get(Subject.class, id));
    }

    @SuppressWarnings(value = "unchecked")
    public List<Subject> queryAllSubjects() {        //根据类型查询所有科目
        return hibernateDQL(session -> session.createQuery(
                "from Subject"
        ).list());
    }

    private static final String ISO8859_1 = "ISO8859-1";
}
