package com.morrison.controllers;

import com.morrison.models.Product;
import com.morrison.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    private IProductService iProductService;

    @Autowired(required = true)
    @Qualifier(value = "productService")
    public void setIProductService(IProductService iProductService) {
        this.iProductService = iProductService;
    }


    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String getAllProducts(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("listOfProducts", this.iProductService.getAllProducts());

        return "products";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product){
        if(product.getId() == 0){
            this.iProductService.addProduct(product);
        }else {
            this.iProductService.updateProduct(product);
        }

        return "redirect:/addProduct";
    }

    @RequestMapping("/removeProduct/{id}")
    public String removeProduct(@PathVariable("id") int id){
        this.iProductService.removeProduct(id);

        return "redirect:/products";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("product", this.iProductService.getProductById(id));
        model.addAttribute("products", this.iProductService.getAllProducts());

        return "products";
    }

    @RequestMapping("trolleyData/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("product", this.iProductService.getProductById(id));

        return "trolleyData";
    }
}
