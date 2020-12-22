package pl.edu.wszib.magazyn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.magazyn.database.IProductsRepository;
import pl.edu.wszib.magazyn.model.Product;
import pl.edu.wszib.magazyn.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CommonController {

    @Autowired
    IProductsRepository productsRepository;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landingPage(){
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model){
        List<Product> products = this.productsRepository.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        return "main";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactPage(Model model){
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "contact";
    }


}
