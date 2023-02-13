package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
/**
 *
 * @author qball
 */
public class LoginServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        if (logout != null) {
            session.invalidate();
        }
        HttpSession session2 = request.getSession();
        if(session2.getAttribute("username") != null){
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
        if (logout != null) {
            request.setAttribute("message", "You have successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();    
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        if (username != "" && password != "") {
            if (User.login(username, password) == null){
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.setAttribute("message", "Invalid Login");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            } else {
                session.setAttribute("user",username);
                response.sendRedirect("http://localhost:8084/Week5Lab_MyLogin/home");
            }
        }
        else {
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }

}
