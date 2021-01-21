package me.minhthien.service;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import me.minhthien.exception.DuplicateEntityException;
import me.minhthien.exception.EntityNotFoundException;
import me.minhthien.model.Quiz;
import me.minhthien.model.Subject;
import me.minhthien.repository.QuizRepository;
import me.minhthien.repository.SubjectRepository;

public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final QuizRepository quizRepository;
    
    public SubjectService() {
        this.subjectRepository = new SubjectRepository();
        this.quizRepository = new QuizRepository();
    }
    
    public void saveOrUpdate(HttpServletRequest request) {
        String name = request.getParameter("name");

        Subject subject = new Subject();
        subject.setName(name);
        subject.setCreateDate(LocalDate.now());

        if(request.getParameter("id") == null || request.getParameter("id").isBlank()) {
            // Create
            boolean existSubject = subjectRepository.checkExistSubject(name);
            if(existSubject)
                throw new DuplicateEntityException(String.format("Duplicated : Subject [name : %s] already existed", name));

            subjectRepository.createSubject(subject);
        } else {
            // Update
            Integer id = Integer.parseInt(request.getParameter("id"));
            subject.setId(id);
            subjectRepository.updateSubject(subject);
        }

    }

    public List<Subject> findAll() {
        return subjectRepository.getAllSubject();
    }

    public Subject findById(int id) {
        boolean exist = subjectRepository.checkExistSubject_withId(id);
        if (!exist)
            throw new EntityNotFoundException(
                String.format("Subject [id : %s] isn't exists", id));

        return subjectRepository.getSubject(id);
    }
    
    public Subject findDetailById(int id) {
        boolean exist = subjectRepository.checkExistSubject_withId(id);
        if (!exist)
            throw new EntityNotFoundException(
                String.format("Subject [id : %s] isn't exists", id));
    
        Subject subject = subjectRepository.getSubject(id);
        List<Quiz> quizzes = quizRepository.getAllQuizBySubjectId(subject.getId());
        subject.setQuizzes(quizzes);
    
        return subject;
    }

    public boolean delete(int id) {
        return subjectRepository.deleteSubject(id);
    }
}
