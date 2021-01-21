package me.minhthien.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import me.minhthien.common.Validator;
import me.minhthien.common.ViewName;
import me.minhthien.model.Quiz;
import me.minhthien.model.Subject;
import me.minhthien.service.QuizService;
import me.minhthien.service.SubjectService;

@WebServlet(name = "QuizController", urlPatterns = {
    "/dashboard/quizzes/*"
})
public class QuizController extends HttpServlet {
    
    private final QuizService quizService;
    private final SubjectService subjectService;
    private final Validator validator;
    
    public QuizController() {
        this.quizService = new QuizService();
        this.subjectService = new SubjectService();
        this.validator = new Validator();
    }
    
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getPathInfo();
        switch (action) {
            case "/process":
                processForm(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getPathInfo();
        if(action == null)
            list(request, response);
        else {
            switch (action) {
                case "/create":
                    showCreateForm(request, response);
                    break;
                case "/update":
                    showUpdateForm(request, response);
                    break;
                case "/question-add":
                    addQuestion(request, response);
                    break;
                case "/delete":
                    delete(request, response);
                    break;
            }
        }
    }
    
    
    
    /*
    *   CREATE
    * */
    private void showCreateForm(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Subject> subjects = subjectService.findAll();
        request.setAttribute("subjects", subjects);
        RequestDispatcher dispatcher = request.getRequestDispatcher(ViewName.QUIZ_FORM);
        dispatcher.forward(request, response);
    }
    
    /*
    *   UPDATE
    * */
    private void showUpdateForm(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Subject> subjects = subjectService.findAll();
    
        Integer id  = checkExistIdParam(request, response);
        Quiz quiz = quizService.findById(id);
        
        request.setAttribute("quiz", quiz);
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher(ViewName.QUIZ_FORM).forward(request, response);
    }

    private void processForm(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HashMap<String, String> errors = new HashMap<>();
        
        validator.checkRequired("name", request, errors);
        validator.checkRequired("timeout", request, errors);
    
        validator.checkInteger("timeout", request, errors);
        
        if(errors.size() > 0) {
            HashMap<String, String> quiz = new HashMap<>();
            quiz.put("name", request.getParameter("name"));
            quiz.put("timeout", request.getParameter("timeout"));
            quiz.put("subjectId", request.getParameter("subject_id"));
    
            List<Subject> subjects = subjectService.findAll();
            request.setAttribute("subjects", subjects);
            
            request.setAttribute("quiz", quiz);
            request.setAttribute("errors", errors);
            request.getRequestDispatcher(ViewName.QUIZ_FORM).forward(request, response);
            return;
        }
        
        quizService.saveOrUpdate(request);
        redirectToList(request, response);
    }
    /*
    *   DELETE
    * */
    private void delete(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Integer id = checkExistIdParam(request, response);
        boolean delete = quizService.delete(id);
        if(!delete) {
            request.setAttribute("error", "Can't delete quiz");
            getAll(request, response);
            return;
        }

        redirectToList(request, response);
    }

    private void list(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String quizId = request.getParameter("id");
        if (quizId != null) {
            getOne(request, response);
        } else
            getAll(request, response);
    }

    private void getOne(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Integer id  = checkExistIdParam(request, response);
        Quiz quiz = quizService.findDetailById(id);
    
        request.setAttribute("quiz", quiz);
        request.getRequestDispatcher(ViewName.QUIZ_DETAIL).forward(request, response);
    }

    private void getAll(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Quiz> quizzes = quizService.findAll();
        request.setAttribute("quizzes", quizzes);
        request.getRequestDispatcher(ViewName.QUIZ_LIST)
            .forward(request, response);
    }
    
    private void showQuestion(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
    }
    
    private void addQuestion(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
//        Integer id  = checkExistIdParam(request, response);
//        Quiz quiz = quizService.findById(id);
//
//        request.setAttribute("quiz", quiz);
//        request.setAttribute("subjects", subjects);
//        request.getRequestDispatcher(ViewName.QUIZ_FORM).forward(request, response);
    }
    
    /*
    *  Tools
    * */
    private Integer checkExistIdParam(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String quizId = request.getParameter("id");
        if (quizId == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        } else {
            return Integer.parseInt(quizId);
        }
    }
    
    private void redirectToList(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/dashboard/quizzes");
    }
}
