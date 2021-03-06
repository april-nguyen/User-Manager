package com.hcl.usermanager.service;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoggedInValidator implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpSession session = ((HttpServletRequest) request).getSession(false);

            if (session !=  null && session.getAttribute("userId") != null) {
                chain.doFilter(request, response);
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
