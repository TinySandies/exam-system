package top.tinysand.dao;

import top.tinysand.model.Subject;

import java.util.List;

public interface ISubjectRepo {
    boolean saveSubject(Subject subject);

    boolean updateSubject(Subject subject);

    boolean deleteSubject(Integer subjectId);

    Subject querySubject(Integer subjectId);

    List<Subject> querySubjects();
}
