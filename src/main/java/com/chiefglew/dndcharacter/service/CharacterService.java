package com.chiefglew.dndcharacter.service;

import com.chiefglew.dndcharacter.application.races.CharacterInterface;

import java.util.List;

public interface CharacterService {
    List<CharacterInterface> getAllCharacters();

    CharacterInterface getCharacter(long characterId);
}
