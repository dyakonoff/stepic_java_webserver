package main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


public class MirrorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> parameters = request.getParameterMap();
        if (!parameters.isEmpty()) {
            String[] vals = parameters.values().stream().findFirst().get();
            if (vals.length > 0) {
                response.getWriter().print(vals[0]);
            }
        }

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
