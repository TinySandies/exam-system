package top.tinysand.dao.repository;

import org.springframework.stereotype.Repository;
import top.tinysand.dao.AbstractRepository;
import top.tinysand.model.ExamTest;

import java.util.List;

@Repository(value = "examTestRepo")
public class ExamTestRepo extends AbstractRepository {
    /*保存实体*/
    public boolean saveExamTest(ExamTest examTest) {
        hibernateDML(session -> session.save(examTest));
        return true;
    }

    /*更新实体*/
    public boolean updateExamTest(ExamTest examTest) {
        hibernateDML(session -> session.update(examTest));
        return true;
    }

    /*根据实体删除数据*/
    public boolean deleteExamTest(ExamTest examTest) {
        hibernateDML(session -> session.delete(examTest));
        return true;
    }

    /*根据主键查询一条数据*/
    public ExamTest queryExamTest(Integer id) {
        return hibernateDQL(session -> session.get(ExamTest.class, id));
    }

    /*根据类型查询多条数据*/
    @SuppressWarnings(value = "unchecked")
    public List<ExamTest> queryAllExamTest() {
        return hibernateDQL(session -> session.createQuery(
                "from ExamTest"
        ).list());
    }
}
