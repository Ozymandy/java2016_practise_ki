package customerproductorder.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        try {
            ResultSet set;
            Connection conn;
            Class.forName("org.h2.Driver");
            String res = "test";
            try {
                conn = DriverManager.
                        getConnection("jdbc:h2:~/test", "root", "root");
                Statement st = conn.createStatement();
                set = st.executeQuery("SELECT * FROM user");
                while(set.next()){
                    res = res + set.getString("NAME");
                }
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            PrintWriter out = resp.getWriter();
            out.print(res);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
