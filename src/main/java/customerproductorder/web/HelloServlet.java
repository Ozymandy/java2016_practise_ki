

package customerproductorder.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
     /**
    * This class provide us using servlets.
    */
public class HelloServlet extends HttpServlet {
         /** This method is called when we send get to server.*/
    private static final Logger LOG =  LoggerFactory.getLogger(HelloServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("<h1>Hello from App developed by Kostya</h1>");
        LOG.info("HelloWorld!");

    }
}

