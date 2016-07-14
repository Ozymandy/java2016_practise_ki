package customerproductorder.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import customerproductorder.DataContainer;

public class CustomersServlet extends HttpServlet {

    private static final DataContainer dataContainer = DataContainer.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("customers", dataContainer.getCustomers());
        getServletContext().getRequestDispatcher("/customers.jsp").forward(req, resp);

    }
}
