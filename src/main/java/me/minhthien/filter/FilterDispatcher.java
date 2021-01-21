package me.minhthien.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDispatcher implements Filter {
    
    public void destroy() {
    }
    
    public void doFilter(ServletRequest req, ServletResponse resp,
        FilterChain chain)
        throws ServletException, IOException {
        System.out.println("Before Filter");
        chain.doFilter(req, resp);
        System.out.println("After Filter");
    }
    
    public void init(FilterConfig config) throws ServletException {
        
    }
    
}
