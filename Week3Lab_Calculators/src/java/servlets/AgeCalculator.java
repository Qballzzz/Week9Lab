/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author qball
 */
public class AgeCalculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String age = request.getParameter("age");
        Integer ageNum;
        String AgeNext;
        try{
            Integer.parseInt(age);
        }catch(NumberFormatException e){
            AgeNext = "You must give your current age.";
            request.setAttribute("ageNext", AgeNext);
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
            return;
        }
        Integer nextAge;
        AgeNext = "Your age next birthday will be ";
        ageNum = Integer.parseInt(age);
        if (ageNum >= 0) {
            nextAge = ageNum + 1;
            AgeNext += nextAge.toString();
        }else{
            AgeNext = "You must give your current age.";
        }
            request.setAttribute("ageNext", AgeNext);
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
    }
}
