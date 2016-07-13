package customerproductorder.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import customerproductorder.DataContainer;

/**
 * This class provide us using servlets.
 */
public class CustomersServlet extends HttpServlet {

    /**
     * This method is called when we send get to server.
     */
    private static final DataContainer container = DataContainer.instance;

    public CustomersServlet() {
        super();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("customers", container.getCustomers());
        getServletContext().getRequestDispatcher("/customers.jsp").forward(req, resp);

    }
}
