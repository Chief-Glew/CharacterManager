package com.chiefglew.dndcharacter.application.items;

import com.chiefglew.dndcharacter.application.items.currency.PlatinumPiece;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValuableTest {

    @Test
    public void testThatTheValuableNameOfAPlatinumPieceIsPlatinumPiece(){
        Valuable platinumPiece = new PlatinumPiece();
        assertEquals("PlatinumPiece",platinumPiece.getValuableName());
    }
}
