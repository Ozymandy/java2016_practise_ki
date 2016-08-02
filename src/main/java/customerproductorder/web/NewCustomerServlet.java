package customerproductorder.web;

import customerproductorder.models.Customer;
import dao.DaoException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import services.customer.CustomerService;
import services.customer.CustomerServiceInterface;

public class NewCustomerServlet extends HttpServlet {

    private static CustomerServiceInterface service = CustomerService
            .getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, NumberFormatException {
        getServletContext().getRequestDispatcher("/new.jsp").forward(req,
                resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            service.create(new Customer(req.getParameter("firstName"),
                    req.getParameter("lastName"), req.getParameter("address")));
            resp.sendRedirect("list");
        } catch (DaoException e) {

        }

    }
}
