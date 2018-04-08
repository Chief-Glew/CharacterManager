package com.chiefglew.dndcharacter.application.handlers;

import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;

public class LinkCountingCharArrayHandler extends CharArrayHandler<Integer> {
    public LinkCountingCharArrayHandler(Character[] array) {
        super(array);
    }

    public LinkCountingCharArrayHandler(String characterArrayAsString){
        this(characterArrayAsString.chars().mapToObj(c -> (char)c).toArray(Character[]::new));
    }

    @Override
    public Integer handle(Character[] characters) throws CouldNotHandleException {
        return handleNext(characters)+1;
    }
    public Integer handle(String characterArrayAsString) throws CouldNotHandleException {
        return handle(characterArrayAsString.chars().mapToObj(c -> (char)c).toArray(Character[]::new));
    }

    @Override
    public Integer handlerMethod(Character[] characters) {
        return 0;
    }

    public Integer handleFromHead(String characterArrayAsString) throws CouldNotHandleException {
        return super.handleFromHead(characterArrayAsString.chars().mapToObj(c -> (char)c).toArray(Character[]::new));
    }
}
