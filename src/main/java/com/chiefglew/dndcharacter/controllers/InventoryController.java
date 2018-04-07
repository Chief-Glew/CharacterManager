package com.chiefglew.dndcharacter.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InventoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);

	List<String> messages = new ArrayList<String>();

    public InventoryController() {
        LOGGER.info("InventoryController initialised");
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

	@GetMapping("/")
	public String showInventories(Model model) {
		return "index";
	}

	@PostMapping("/messenger")
	public String showInventoryItems(@RequestParam("message") String message, Model model){
	    LOGGER.warn("messages requested");
		this.messages.add(message);
		model.addAttribute("messages" , this.messages);
		return "messenger";
	}
	
	@GetMapping("/messenger" )
	public String showInventoryItems(Model model){
		model.addAttribute("messages" , messages);
		return "messenger";
	}
}
