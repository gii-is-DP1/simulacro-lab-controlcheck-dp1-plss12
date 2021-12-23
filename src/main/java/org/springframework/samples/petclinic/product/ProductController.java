package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
	public static final String PRODUCTS_FORM =  "products/createOrUpdateProductForm";
	public static final String PRODUCTS_OK =  "welcome";


	@Autowired
	ProductService productService;
	
	@GetMapping("/create")
	public String newProduct(ModelMap model) {
		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("productTypes", productService.getAllProductTypes());
		return PRODUCTS_FORM;
	}
	
	@PostMapping("/create")
	public String newProduct(@Valid Product product, BindingResult result) {
		if(result.hasErrors()) {
			return PRODUCTS_FORM;
		} else {
			productService.save(product);
			return PRODUCTS_OK;
		}
	}
}
