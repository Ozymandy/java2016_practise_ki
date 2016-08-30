package customerproductorder.web.Controllers;

import customerproductorder.models.Customer;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.customer.CustomerServiceInterface;

@Controller
@ComponentScan("customerapplication.services.customer")
public class CustomerController {

    private final static Logger LOG = LoggerFactory
            .getLogger(CustomerController.class);
    @Autowired
    private CustomerServiceInterface customerService;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listCustomers() {
        List<Customer> customers = customerService.getAll();
        ModelAndView model = new ModelAndView("customers");
        model.addObject("list", customers);
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editCustomer(@RequestParam("id") int id) {
        ModelAndView model = new ModelAndView("edit");
        model.addObject("customer",customerService.get(id));
        return model;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editCustomer(@ModelAttribute("customer") Customer customer) {
        ModelAndView model = new ModelAndView("edit");
        customerService.save(customer);
        return model;
    }
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newCustomer() {
        ModelAndView model = new ModelAndView("new");
        return model;
    }
}
