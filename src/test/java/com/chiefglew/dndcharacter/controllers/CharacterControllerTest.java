package com.chiefglew.dndcharacter.controllers;

import com.chiefglew.dndcharacter.application.races.CharacterInterface;
import com.chiefglew.dndcharacter.service.CharacterService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CharacterControllerTest {

    @Mock
    private CharacterService characterService;
    @Mock
    private Model model;
    @Mock
    private List<CharacterInterface> characterList;
    @Mock
    private CharacterInterface characterInterface;
    private CharacterController characterController;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(characterService.getAllCharacters()).thenReturn(characterList);
        Mockito.when(characterService.getCharacter(1l)).thenReturn(characterInterface);
        characterController = new CharacterController(characterService);
    }

    @Test
    public void testThatGetCharacterListAddsAMapOfIntegersAndCharactersContainingAllTheCharactersTheCharacterServiceKnowsAbout(){
        characterController.getCharacterList(model);
        Mockito.verify(model).addAttribute("characters", characterList);
    }

//    @Ignore //test is no longer applicable, spring handles the model adding stuff, the flow of the test still represents what's going on though, maybe i'll delete this
//    @Test
//    public void testThatGetCharacterSheetPutsTheExpectedCharacterIntoTheModel(){
//        characterController.getCharacterSheet(characterInterface);
//        Mockito.verify(model).addAttribute("characterInterface", characterInterface);
//    }
}