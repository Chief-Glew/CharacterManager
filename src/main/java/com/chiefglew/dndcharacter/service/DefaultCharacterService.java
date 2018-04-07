package com.chiefglew.dndcharacter.service;

import com.chiefglew.dndcharacter.application.races.CharacterInterface;
import com.chiefglew.dndcharacter.application.races.Elf;
import com.chiefglew.dndcharacter.backend.CRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DefaultCharacterService implements CharacterService {

    @Autowired
    private CRUD<CharacterInterface> characterCRUD;

    @Override
    public List<CharacterInterface> getAllCharacters() {
        return characterCRUD.readAll();
    }

    @Override
    public CharacterInterface getCharacter(long characterId) {
        return characterCRUD.read(characterId);
    }
}
