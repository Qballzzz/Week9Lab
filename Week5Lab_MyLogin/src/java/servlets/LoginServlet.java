package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            String message = "You have successfully logged out";
            request.setAttribute("error", message);
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
            
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        
        if (username != "" && password != "") {
            if (User.login(username, password) == null){
                request.setAttribute("username",username);
                request.setAttribute("password",password);
                String error = "Invalid Login";
                request.setAttribute("error",error);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            } else {
                session.setAttribute("user",username);
                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
            }
        }
        else {
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }

}
