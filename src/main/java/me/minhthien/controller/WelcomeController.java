package me.minhthien.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import me.minhthien.common.ViewName;

@WebServlet("/")
public class WelcomeController extends HttpServlet {
    
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        
    }
    
    protected void doGet(HttpServletRequest req,
        HttpServletResponse res)
        throws ServletException, IOException {
        req.getRequestDispatcher(ViewName.WELCOME).forward(req, res);
    }
}
