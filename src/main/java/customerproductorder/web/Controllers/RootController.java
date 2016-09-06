package customerproductorder.web.Controllers;

import customerproductorder.models.User;
import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.users.UserServiceInterface;

@Controller
public class RootController {

    @Autowired
    private UserServiceInterface userService;
    private Logger LOG = LoggerFactory.getLogger(RootController.class);
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView("login");
        LOG.info("ko-ko-ko");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,
            HttpServletResponse response,@RequestParam("user") String username,
            @RequestParam("password") String password) {
        ModelAndView model;
        int minutes=30;
        int seconds = 60;
        User user = new User(username,password);
        if(userService.isValid(user)){
            model=new ModelAndView("index");
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            session.setMaxInactiveInterval(minutes*seconds);
            model = new ModelAndView("redirect:/");
        }
        else{
            model = new ModelAndView("redirect:loginerror");
        }
        return model;
    }
    @RequestMapping(value="/",method=RequestMethod.GET)
    public ModelAndView getIndex(){
        return new ModelAndView("index");
    }
}
