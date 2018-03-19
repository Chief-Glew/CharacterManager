package com.chiefglew.dndcharacter.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InventoryController {


	List<String> messages = new ArrayList<String>();
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String showInventories(Model model) {
		return "index";
	}
	
//	@RequestMapping(value = { "/{inventoryId}/" }, method = RequestMethod.GET)
//	public String showInventoryItems(@PathVariable long inventoryId, Model model){
//		model.addAttribute("iventoryNumber" , inventoryId);
//		return "showInventoryItems";
//	}
	
	@RequestMapping(value = { "/messenger/" }, method = RequestMethod.POST)
	public String showInventoryItems(@RequestParam("message") String message, Model model){
		this.messages.add(message);
		model.addAttribute("messages" , this.messages);
		return "messenger";
	}
	
	@RequestMapping(value = { "/messenger/" }, method = RequestMethod.GET)
	public String showInventoryItems(Model model){
		model.addAttribute("messages" , messages);
		return "messenger";
	}
}
