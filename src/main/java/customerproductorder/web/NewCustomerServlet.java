package customerproductorder.web;

import customerproductorder.DataContainer;
import customerproductorder.models.Customer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class provide us using servlets.
 */
public class NewCustomerServlet extends HttpServlet {

    /**
     * This method is called when we send get to server.
     */
    private int cardId;
    private static DataContainer container = DataContainer.instance;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        cardId = Integer.parseInt(req.getParameter("cardId"));
        getServletContext().getRequestDispatcher("/new.jsp").forward(req,
                resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        container.getCustomers().add(this.addCustomer(req));
        resp.sendRedirect("list");

    }

    private Customer addCustomer(HttpServletRequest req) {
        Customer customer = new Customer(req.getParameter("firstName"),
                req.getParameter("lastName"), req.getParameter("address"),
                cardId);
        return customer;
    }
}
