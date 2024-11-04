package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	
	ProdService pr1;
	
	public MyController(ProdService pr1) {
		
		this.pr1 = pr1;
	}
	
	@GetMapping("/")
	@ResponseBody
	public String insertProd() {
		
		//pr1.createProd("Insalata", "Bonduelle", 3, "url.jpg");
		// pr1.updatePrezzo("Insalata",2);
		pr1.deleteProd("Insalata");
		
	ArrayList <Prodotto> lista = pr1.getAllProd();
		//d1.updateStipendio("Bianchi", 4000);
		//d1.deleteDip("Bianchi");
		for (Prodotto p1: lista){
			
			System.out.println(p1);}
		
		return ("ciao");
		
		
	}
	

	
	
	
}
