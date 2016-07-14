package customerproductorder.web;

import customerproductorder.DataContainer;
import customerproductorder.models.Customer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

public class NewCustomerServlet extends HttpServlet {

    private static DataContainer dataContainer = DataContainer.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, NumberFormatException {
        int cardId = Integer.parseInt(req.getParameter("cardId"));
        HttpSession session = req.getSession();
        session.setAttribute("cardId", cardId);
        getServletContext().getRequestDispatcher("/new.jsp").forward(req,
                resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        dataContainer.getCustomers().add(this.addCustomer(req));
        resp.sendRedirect("list");

    }

    private Customer addCustomer(HttpServletRequest req) {
        HttpSession session = req.getSession();
        int cardId = (Integer)session.getAttribute("cardId");
        Customer customer = new Customer(req.getParameter("firstName"),
                req.getParameter("lastName"), req.getParameter("address"),
                cardId);
        return customer;
    }
}
