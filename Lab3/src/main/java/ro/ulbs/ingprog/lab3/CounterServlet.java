package ro.ulbs.ingprog.lab3;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CounterServlet", value = "/CounterServlet")
public class CounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer counterGet = (Integer)
                request.getSession().getAttribute("CounterGetName");
        if (counterGet == null) {
            counterGet = 0;
        }
        String increment = request.getParameter("inc");
        if (increment != null && !increment.isEmpty()) {
            counterGet += Integer.parseInt(increment);
        }

        String decrement = request.getParameter("dec");
        if (decrement != null && !decrement.isEmpty()) {
            counterGet -= Integer.parseInt(decrement);
        }
        request.getSession().setAttribute("CounterGetName", counterGet);

        //Atribut care se activeaza cand contorul ajunge la 0
        if (counterGet == 0) {
            request.getSession().setAttribute("WarningGet", true);
        } else {
            request.getSession().removeAttribute("WarningGet");
        }

        status(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer counterPost = (Integer)
                request.getSession().getAttribute("CounterPostName");
        if (counterPost == null) {
            counterPost = 0;
        }
        String increment = request.getParameter("inc");
        if (increment != null && !increment.isEmpty()) {
            counterPost += Integer.parseInt(increment);
        }

        String decrement = request.getParameter("dec");
        if (decrement != null && !decrement.isEmpty()) {
            counterPost -= Integer.parseInt(decrement);
        }
        request.getSession().setAttribute("CounterPostName", counterPost);

        //Atribut care se activeaza cand contorul ajunge la 0
        if (counterPost == 0) {
            request.getSession().setAttribute("WarningPost", true);
        } else {
            request.getSession().removeAttribute("WarningPost");
        }

        status(request, response);
    }

    private void status(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h2>Welcome to Counter Servlet</h2>");

        Integer counterGet = (Integer) request.getSession().getAttribute("CounterGetName");
        printWriter.println("<br> Counter for GET: " + counterGet);

        if (request.getSession().getAttribute("WarningGet") != null) {
            printWriter.print(" <span style='color:red;'>WARNING GET</span>");
        }

        Integer counterPost = (Integer) request.getSession().getAttribute("CounterPostName");
        printWriter.println("<br> Counter for POST: " + counterPost);

        if (request.getSession().getAttribute("WarningPost") != null) {
            printWriter.print(" <span style='color:red;'>WARNING POST</span>");
        }
    }
}

