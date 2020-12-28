package pl.edu.wszib.magazyn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.magazyn.database.IProductsRepository;
import pl.edu.wszib.magazyn.services.IProductService;
import pl.edu.wszib.magazyn.services.IStorageService;
import pl.edu.wszib.magazyn.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class StorageController {


    IStorageService storageService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/storage", method = RequestMethod.GET)
    public String basket(Model model){
        if (!this.sessionObject.isLogged()){
            return "redirect:/login";
        }
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("products", this.sessionObject.getStorage());
        return "storage";
    }
}
