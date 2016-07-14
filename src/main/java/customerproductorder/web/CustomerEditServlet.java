package customerproductorder.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import customerproductorder.DataContainer;
import customerproductorder.models.Customer;
import javax.servlet.http.HttpSession;

public class CustomerEditServlet extends HttpServlet {

    private static final DataContainer dataContainer = DataContainer.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int cardId = Integer.parseInt(req.getParameter("cardId"));
        Customer editCustomer = dataContainer.searchCustomerByCardId(cardId);
        HttpSession session = req.getSession(true);
        session.setAttribute("editCustomer", editCustomer);
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
        HttpSession session = req.getSession(true);
        Customer customer = (Customer) session.getAttribute("editCustomer");
        int index = dataContainer.getCustomers().indexOf(customer);
        dataContainer.getCustomers().set(index, new Customer(req.getParameter("firstName"),
                req.getParameter("lastName"), req.getParameter("address"),
                customer.getCardNumber()));
    }
}
