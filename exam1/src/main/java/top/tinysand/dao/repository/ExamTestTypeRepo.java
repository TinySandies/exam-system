package top.tinysand.dao.repository;

import org.springframework.stereotype.Repository;
import top.tinysand.dao.AbstractRepository;
import top.tinysand.model.ExamTestType;

import java.util.List;

@Repository(value = "examTestTypeRepo")
public class ExamTestTypeRepo extends AbstractRepository {
    /*保存实体*/
    public boolean saveExamTestType(ExamTestType examTestType) {
        hibernateDML(session -> session.save(examTestType));
        return true;
    }

    /*更新实体*/
    public boolean updateExamTestType(ExamTestType examTestType) {
        hibernateDML(session -> session.update(examTestType));
        return true;
    }

    /*根据实体删除数据*/
    public boolean deleteExamTestType(ExamTestType examTestType) {
        hibernateDML(session -> session.delete(examTestType));
        return true;
    }

    /*根据主键查询一条数据*/
    public ExamTestType queryExamTestType(Integer id) {
        return hibernateDQL(session -> session.get(ExamTestType.class, id));
    }

    /*根据类型查询多条数据*/
    @SuppressWarnings(value = "unchecked")
    public List<ExamTestType> queryAllExamTestType() {
        return hibernateDQL(session -> session.createQuery(
                "from ExamTestType"
        ).list());
    }
}
