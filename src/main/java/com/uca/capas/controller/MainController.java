package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Product;

@Controller
public class MainController {
	
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0, "Alas", 25));
		productos.add(new Product(1, "boneless", 19));
		productos.add(new Product(2, "aceite", 35));
		productos.add(new Product(3, "salsa buffalo", 10));
		productos.add(new Product(4, "manojo de cebollin", 23));
		productos.add(new Product(5, "blue cheese", 50));
		productos.add(new Product(6, "apio", 55));
		productos.add(new Product(7, "miel de abeja", 12));
		
		mav.setViewName("productos");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);

		return mav;	
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", productos.get(product.getId()).getNombre());
		if(productos.get(product.getId()).getCantidad() >= product.getCantidad() && product.getCantidad() > 0) {
			mav.setViewName("compra");
		}else {
			mav.setViewName("error");
		}
		return mav;
	}
	

}
