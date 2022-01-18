package com.controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persistence.entities.Cart;
import com.services.BakeryService;
import com.services.input.BakeryInputData;
import com.services.input.BakeryOrderInputData;

@RestController
@RequestMapping("/bakery")
public class BakeryController {
	
	@Autowired
	private BakeryService bakeryService;


	@PostMapping
	public Cart processOrder(@RequestBody BakeryInputData bakeryInputData)throws Exception{
	
		return bakeryService.processOrder(bakeryInputData);
	}
	 
	@GetMapping
	public BakeryInputData getformat(){
		BakeryInputData bakeryInputData = new BakeryInputData();
		BakeryOrderInputData bakeryOrderInputData = new BakeryOrderInputData();
		bakeryOrderInputData.setCode("VS5");
		bakeryOrderInputData.setUnits(10);
		List<BakeryOrderInputData> lista = new ArrayList<>();
		lista.add(bakeryOrderInputData);
		lista.add(bakeryOrderInputData);
		bakeryInputData.setBakeryOrder(lista);
		return bakeryInputData;
	}
	
}
