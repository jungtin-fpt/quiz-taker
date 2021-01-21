package me.minhthien.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {
    
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        
    }
    
    protected void doGet(HttpServletRequest req,
        HttpServletResponse res)
        throws ServletException, IOException {
        res.sendRedirect(req.getContextPath() + "/dashboard/subjects");
    }
}
