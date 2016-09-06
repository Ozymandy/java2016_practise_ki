package customerproductorder.web.Controllers;

import customerproductorder.models.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.customer.CustomerServiceInterface;

@Controller
public class CustomerController {

    @Autowired
    private CustomerServiceInterface customerService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView viewCustomers() {
        List<Customer> customers = customerService.getAll();
        ModelAndView model = new ModelAndView("customers");
        model.addObject("list", customers);
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView saveCustomer(@RequestParam("id") int id) {
        ModelAndView model = new ModelAndView("edit");
        model.addObject("item", customerService.get(id));
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView saveCustomer(@RequestParam("address") String address,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("id") int id) {
        Customer customer = new Customer(firstName, lastName, address, id);
        customerService.save(customer);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newCustomer() {
        ModelAndView model = new ModelAndView("new");
        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView newCustomer(@RequestParam("address") String address,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        Customer customer = new Customer(firstName, lastName, address);
        customerService.create(customer);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchCustomer() {
        return new ModelAndView("search");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchCustomer(@RequestParam("keyword") 
            String keyword) {
        ModelAndView model = new ModelAndView("search");
        List<Customer> customers = new ArrayList<Customer>();
        for(Customer customer: customerService.getAll()){
            if(customer.getFirstName().contains(keyword)){
                customers.add(customer);
            }
        }
        model.addObject("list",customers);
        return model;
    }
}
