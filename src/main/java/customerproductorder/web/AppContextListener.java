package customerproductorder.web;

import dao.DaoFactory;
import dao.H2Factory.H2DaoFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class AppContextListener implements ServletContextListener {

    private ServletContext context = null;
    private DaoFactory dbdaoFactory;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.dbdaoFactory = H2DaoFactory.getInstance();
        this.context = sce.getServletContext();
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        this.context = null;
    }

}
