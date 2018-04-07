package com.chiefglew.dndcharacter.controllers;

import com.chiefglew.dndcharacter.application.races.CharacterInterface;
import com.chiefglew.dndcharacter.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/CharacterList")
    public String getCharacterList(Model model) {
        List<CharacterInterface> characterList = characterService.getAllCharacters();
        model.addAttribute("characters", characterList);
        return "characterList";
    }
    @GetMapping("/CharacterSheet/{id}/{characterName}")
    public String getCharacterSheet(@PathVariable long id, Model model) {
        CharacterInterface character = characterService.getCharacter(id);
        model.addAttribute("character", character);
        return "characterSheet";
    }
}
