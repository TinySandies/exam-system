package top.tinysand.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tinysand.dao.repository.SubjectRepo;
import top.tinysand.model.Subject;

import java.util.List;

@Service("subjectService")
public class SubjectService {
    public List<Subject> findAllSubjects() {
        return subjectRepository.queryAllSubjects();
    }

    public boolean saveSubject(Subject subject) throws Exception {
        return subjectRepository.saveSubject(subject);
    }

    public Subject findSubjectById(Integer subId) {
        return subjectRepository.querySubject(subId);
    }

    public boolean updateSubject(Subject subject) throws Exception {
        return subjectRepository.updateSubject(subject);
    }

    public boolean deleteSubject(Integer subId) {
        Subject subject = new Subject();
        subject.setSubId(subId);
        return subjectRepository.deleteSubject(subject);
    }

    @Autowired
    public SubjectService(SubjectRepo subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    private SubjectRepo subjectRepository;
}
