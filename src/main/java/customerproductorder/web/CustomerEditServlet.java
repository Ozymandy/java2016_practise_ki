package customerproductorder.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import customerproductorder.models.Customer;
import dao.DaoException;
import javax.servlet.http.HttpSession;
import services.customer.CustomerService;

public class CustomerEditServlet extends HttpServlet {

    private static final CustomerService service = CustomerService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int cardId = Integer.parseInt(req.getParameter("cardId"));
        Customer editCustomer;
        try {
            editCustomer = service.get(cardId);
            HttpSession session = req.getSession(true);
            session.setAttribute("editCustomerId", cardId);
            if (editCustomer != null) {
                req.setAttribute("customer", editCustomer);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(req,
                        resp);
            } else {
                req.getRequestDispatcher("/new").forward(req, resp);
            }
        } catch (DaoException ex) {

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
        int id = (Integer)session.getAttribute("editCustomerId");
        try{
        service.save(new Customer(req.getParameter("firstName"),
                req.getParameter("lastName"), req.getParameter("address"),id));}
        catch(DaoException e){
            
        }
    }
}
