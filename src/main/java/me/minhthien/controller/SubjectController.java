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
import me.minhthien.model.Subject;
import me.minhthien.service.SubjectService;

@WebServlet(name = "SubjectController", urlPatterns = {
    "/dashboard/subjects/*"
})
public class SubjectController extends HttpServlet {
    
    private final SubjectService subjectService;
    private final Validator validator;
    
    public SubjectController() {
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
        RequestDispatcher dispatcher = request.getRequestDispatcher(ViewName.SUBJECT_FORM);
        dispatcher.forward(request, response);
    }
    
    /*
    *   UPDATE
    * */
    private void showUpdateForm(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Integer id  = checkExistIdParam(request, response);
        Subject subject = subjectService.findById(id);
        request.setAttribute("subject", subject);
        request.getRequestDispatcher(ViewName.SUBJECT_FORM).forward(request, response);
    }

    private void processForm(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HashMap<String, String> errors = new HashMap<>();
        
        validator.checkRequired("name", request, errors);
        
        if(errors.size() > 0) {
            HashMap<String, String> subject = new HashMap<>();
            subject.put("name", request.getParameter("name"));
            
            request.setAttribute("subject", subject);
            request.setAttribute("errors", errors);
            request.getRequestDispatcher(ViewName.SUBJECT_FORM).forward(request, response);
            return;
        }
        
        subjectService.saveOrUpdate(request);
        redirectToList(request, response);
    }
    /*
    *   DELETE
    * */
    private void delete(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Integer id = checkExistIdParam(request, response);
        boolean delete = subjectService.delete(id);
        if(!delete) {
            request.setAttribute("error", "Can't delete subject");
            getAll(request, response);
            return;
        }

        redirectToList(request, response);
    }

    private void list(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String subjectId = request.getParameter("id");
        if (subjectId != null) {
            getOne(request, response);
        } else
            getAll(request, response);
    }

    private void getOne(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Integer id = checkExistIdParam(request, response);
        Subject subject = subjectService.findDetailById(id);
    
        System.out.println(subject);
        System.out.println(subject.getQuizzes());
        
        request.setAttribute("subject", subject);
        request.getRequestDispatcher(ViewName.SUBJECT_DETAIL)
            .forward(request, response);
    }

    private void getAll(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Subject> subjects = subjectService.findAll();
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher(ViewName.SUBJECT_LIST)
            .forward(request, response);
    }
    
    /*
    *  Tools
    * */
    private Integer checkExistIdParam(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String subjectId = request.getParameter("id");
        if (subjectId == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        } else {
            return Integer.parseInt(subjectId);
        }
    }
    
    private void redirectToList(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/dashboard/subjects");
    }
}
