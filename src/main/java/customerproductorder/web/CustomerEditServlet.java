package customerproductorder.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import customerproductorder.DataContainer;
import customerproductorder.models.Customer;

/**
 * This class provide us using servlets.
 */
public class CustomerEditServlet extends HttpServlet {

    /**
     * This method is called when we send get to server.
     */
    private static final DataContainer container = DataContainer.instance;
    //private int cardId;
    private Customer editCustomer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int cardId = Integer.parseInt(req.getParameter("cardId"));
        editCustomer = container.searchCustomerByCardId(cardId);
        if (editCustomer != null) {
            req.setAttribute("customer", editCustomer);
            getServletContext().getRequestDispatcher("/edit.jsp").forward(req,
                    resp);
        } else {
            req.getRequestDispatcher("/new").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        saveCustomer(req);
        resp.sendRedirect("list");

    }

    private void saveCustomer(HttpServletRequest req) {
        //bad expression
        int index = container.getCustomers().indexOf(editCustomer);
        container.getCustomers().set(index, new Customer
                (req.getParameter("firstName"),
                req.getParameter("lastName"), req.getParameter("address"),
                editCustomer.getCardNumber()));
    }
}
