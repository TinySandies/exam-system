//package top.tinysand.dao.implement;
//
//import org.springframework.stereotype.Repository;
//import top.tinysand.model.ExamTest;
//
//import java.util.List;
//@Repository(value = "overrideRepo")
//public class OverrideRepo extends BaseHibernateRepo<ExamTest> {
//    /*保存实体*/
//    public void saveModel(ExamTest examTest) {
//        save(examTest);
//    }
//
//    /*更新实体*/
//    public void updateModel(ExamTest examTest) {
//        update(examTest);
//    }
//
//    /*根据实体删除数据*/
//    public void deleteModel(ExamTest examTest) {
//       delete(examTest);
//    }
//
//    /*根据主键查询一条数据*/
//    public ExamTest queryRecord(Integer id) {
//        return get(ExamTest.class, id);
//    }
//
//    /*根据类型查询多条数据*/
//    public List<ExamTest> queryRecords() {
//        return queryForList("from ExamTest", null);
//    }
//}
