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
public class ArithmeticCalculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("result", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        try{
            Integer.parseInt(first);
            Integer.parseInt(second);
        }catch(NumberFormatException e){
            String result = "invalid";
            request.setAttribute("result", result);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp").forward(request, response);
            return;
        }
        Integer firstNum = Integer.parseInt(first);
        Integer secondNum = Integer.parseInt(second);
        Integer result = 0;
        if(request.getParameter("submit").equals("+")){
            result = firstNum + secondNum;
        }else if(request.getParameter("submit").equals("-")){
            result = firstNum - secondNum;
        }else if(request.getParameter("submit").equals("*")){
            result = firstNum * secondNum;
        }else if(request.getParameter("submit").equals("%")){
            result = firstNum % secondNum;
        }
        request.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp").forward(request, response);
    }
}
