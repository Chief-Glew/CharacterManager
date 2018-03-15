package com.chiefglew.dndcharacter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InventoryController {


	
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String showInventories(Model model) {
		return "index";
	}
	
	@RequestMapping(value = { "/{inventoryId}/" }, method = RequestMethod.GET)
	public String showInventoryItems(@PathVariable long inventoryId, Model model){
		model.addAttribute("iventoryNumber" , inventoryId);
		return "showInventoryItems";
	}
}
