package com.chiefglew.dndcharacter.backend;

import java.util.List;

public interface CRUD<T extends Idable> {
    List<T> readAll();

    default T read(final long id){
        return readAll().stream().filter((idable) -> idable.getId() == id).findAny().get();
    }
}
