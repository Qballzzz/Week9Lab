package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author qball
 */
public class ShoppingListServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        String action = (String) request.getParameter("action");
        if (action != null) {
            if (action.equals("logout")) {
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
        } else {
            if (session.getAttribute("username") != null) {
                ArrayList<String> list = (ArrayList<String>) session.getAttribute("shoplist");
                request.setAttribute("list", list);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if (action.equals("register")) {
            String username = request.getParameter("username");
            session.setAttribute("username", username);
            ArrayList<String> shoplist = new ArrayList<>();
            session.setAttribute("shoplist", shoplist);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else if(action.equals("add")){
             ArrayList<String> list = (ArrayList<String>)session.getAttribute("shoplist");
             String newItem = request.getParameter("newItem");
             list.add(newItem);
             session.setAttribute("shoplist", list);
             request.setAttribute("itemList", list);
             getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
         } else if(action.equals("delete")){
             ArrayList<String> list = (ArrayList<String>)session.getAttribute("shoplist");
             String delete = (String)request.getParameter("itemList");
             list.remove(delete);
             session.setAttribute("shoplist", list);
             request.setAttribute("list", list);
             getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
         } else{
             getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
         }
    }
}
