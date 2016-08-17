package customerproductorder.web;

import customerproductorder.models.Customer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import services.customer.CustomerService;
import services.customer.CustomerServiceInterface;

public class SearchServlet extends HttpServlet {

    private final CustomerServiceInterface service = CustomerService
            .getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
//        if (keyword != null) {
//            req.setAttribute("results", dataContainer.searchBySecondName(keyword));
//        }
        getServletContext().getRequestDispatcher("/search.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
