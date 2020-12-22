package pl.edu.wszib.magazyn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.magazyn.database.IProductsRepository;
import pl.edu.wszib.magazyn.model.Product;
import pl.edu.wszib.magazyn.model.Role;
import pl.edu.wszib.magazyn.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class AdminController {

    @Autowired
    IProductsRepository productsRepository;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/edit/{code}", method = RequestMethod.GET)
    public String editForm(@PathVariable String code, Model model){
        if (!sessionObject.isLogged() || (this.sessionObject.getLoggedUser().getRole() != Role.ADMIN)){
            return "redirect:/login";
        }
        Product product = this.productsRepository.getProductByCode(code);
        model.addAttribute("product", product);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        return "edit";
    }
    @RequestMapping(value = "/edit/{code}", method = RequestMethod.POST)
    public String edit(@ModelAttribute Product product){
        if (!this.sessionObject.isLogged() || (this.sessionObject.getLoggedUser().getRole() != Role.ADMIN)){
            return "redirect:/login";
        }
        Product productFromDB = this.productsRepository.getProductByCode(product.getCode());
        productFromDB.setCategory(product.getCategory());
        productFromDB.setName(product.getName());
        productFromDB.setQuantity(product.getQuantity());
        productFromDB.setPrice(product.getPrice());

        return "redirect:/main";
    }

}
