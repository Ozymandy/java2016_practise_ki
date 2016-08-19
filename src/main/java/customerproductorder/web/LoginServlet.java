package customerproductorder.web;

import customerproductorder.models.User;
import dao.DaoException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.Encryption.MD5EncryptService;
import services.users.UserService;
import services.users.UserServiceInterface;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(LoginServlet.class);
    private static final UserServiceInterface userService = UserService
            .getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user");
        String password = req.getParameter("password");

        User user = new User(username, password);
        try {
            if (userService.isValid(user)) {
                HttpSession session = req.getSession();
                session.setAttribute("user", username);
                session.setMaxInactiveInterval(30 * 60);
                resp.sendRedirect("customers.jsp");
            }
        } catch (DaoException ex) {
            resp.sendRedirect("error.jsp");
        }

    }
}
