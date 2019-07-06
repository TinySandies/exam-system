//package top.tinysand.dao.implement;
//
//import org.springframework.stereotype.Repository;
//import top.tinysand.dao.ISubjectRepo;
//import top.tinysand.model.Subject;
//
//import java.util.List;
//
//@Repository(value = "hSubjectRepo")
//public class HSubjectRepo
//        extends BaseHibernateRepo<Subject> implements ISubjectRepo {
//    @Override
//    public boolean saveSubject(Subject subject) {
//        try {
//            save(subject);
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public boolean updateSubject(Subject subject) {
//        try {
//            update(subject);
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public boolean deleteSubject(Integer subjectId) {
//        try {
//            deleteByKey(subjectId);
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public Subject querySubject(Integer subjectId) {
//        return get(Subject.class, subjectId);
//    }
//
//    @Override
//    public List<Subject> querySubjects() {
//        return queryForList("from Subject", null);
//    }
//}
