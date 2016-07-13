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
public class SearchServlet extends HttpServlet {

    /**
     * This method is called when we send get to server.
     */
    private final DataContainer container = DataContainer.instance;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        if (keyword != null) {
            req.setAttribute("results", container.searchBySecondName(keyword));
        }
        getServletContext().getRequestDispatcher("/search.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
