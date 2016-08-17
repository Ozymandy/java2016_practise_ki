package customerproductorder.web;

import dao.DaoException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.customer.CustomerService;

public class CustomersServlet extends HttpServlet {

    private static final CustomerService service = CustomerService.getInstance();
    private static final Logger LOG = LoggerFactory.getLogger(CustomersServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {

            req.setAttribute("customers", service.getAll());
            getServletContext().getRequestDispatcher("/customers.jsp")
                    .forward(req, resp);
        } catch (DaoException e) {
            resp.sendRedirect("error.jsp");
        }
    }
}
