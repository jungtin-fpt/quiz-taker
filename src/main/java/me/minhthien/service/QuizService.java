package me.minhthien.service;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import me.minhthien.exception.EntityNotFoundException;
import me.minhthien.model.Question;
import me.minhthien.model.Quiz;
import me.minhthien.repository.QuestionRepository;
import me.minhthien.repository.QuizRepository;

public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    
    public QuizService() {
        this.quizRepository = new QuizRepository();
        this.questionRepository = new QuestionRepository();
    }
    
    public void saveOrUpdate(HttpServletRequest request) {
        String name = request.getParameter("name");
        int timeout = Integer.parseInt(request.getParameter("timeout"));
        int subjectId = Integer.parseInt(request.getParameter("subject_id"));

        Quiz quiz = new Quiz();
        quiz.setName(name);
        quiz.setTimeout(timeout);
        quiz.setSubjectId(subjectId);
        quiz.setCreateDate(LocalDate.now());

        if(request.getParameter("id") == null || request.getParameter("id").isBlank()) {
            // Create
//            boolean existQuiz = quizRepository.checkExistQuiz(name);
//            if(existQuiz)
//                throw new DuplicateEntityException(String.format("Duplicated : Quiz [name : %s] already existed", name));

            quizRepository.createQuiz(quiz);
        } else {
            // Update
            Integer id = Integer.parseInt(request.getParameter("id"));
            quiz.setId(id);
            quizRepository.updateQuiz(quiz);
        }

    }

    public List<Quiz> findAll() {
        return quizRepository.getAllQuiz();
    }

    public Quiz findById(int id) {
        boolean exist = quizRepository.checkExistQuiz_withId(id);
        if (!exist)
            throw new EntityNotFoundException(
                String.format("Quiz [id : %s] isn't exists", id));

        return quizRepository.getQuiz(id);
    }

    public boolean delete(int id) {
        return quizRepository.deleteQuiz(id);
    }
    
    public Quiz findDetailById(Integer id) {
        boolean exist = quizRepository.checkExistQuiz_withId(id);
        if (!exist)
            throw new EntityNotFoundException(
                String.format("Quiz [id : %s] isn't exists", id));
    
        Quiz quiz = quizRepository.getQuiz(id);
        List<Question> questions = questionRepository
            .getAllQuestionByQuizId(quiz.getId());
        quiz.setQuestions(questions);
    
        return quiz;
    }
}
