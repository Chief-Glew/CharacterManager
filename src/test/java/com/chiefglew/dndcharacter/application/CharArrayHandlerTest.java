package com.chiefglew.dndcharacter.application;

import com.chiefglew.dndcharacter.application.handlers.LinkCountingCharArrayHandler;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CharArrayHandlerTest {

    private final String input;
    private final Integer expected;
    private LinkCountingCharArrayHandler aHandler;
    private LinkCountingCharArrayHandler aaHandler;
    private LinkCountingCharArrayHandler bHandler;
    private LinkCountingCharArrayHandler cHandler;
    private LinkCountingCharArrayHandler baHandler;
    private LinkCountingCharArrayHandler bbHandler;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "a", 1 }, { "b", 2 }, { "c", 3 }, { "aa", 2 }, { "ba", 3 }, { "bb", 4 }
        });
    }

    public CharArrayHandlerTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }
    @Before
    public void setUp() throws Exception {
        aHandler = new LinkCountingCharArrayHandler("a");
        aaHandler = new LinkCountingCharArrayHandler("aa");
        bHandler = new LinkCountingCharArrayHandler("b");
        cHandler = new LinkCountingCharArrayHandler("c");
        baHandler = new LinkCountingCharArrayHandler("ba");
        bbHandler = new LinkCountingCharArrayHandler("bb");
    }

    @Test
    public void testThatTheListIsCreatedInTheExpectedTreeFormWhenConstructedOnePieceAtATime() throws CouldNotHandleException {
        aHandler
                .addToChain(aaHandler)
                .addToChain(bHandler)
                .addToChain(cHandler)
                .addToChain(baHandler)
                .addToChain(bbHandler);
        assertEquals(expected, aHandler.handle(input));
    }

    @Test
    public void testThatTheListIsCreatedInTheExpectedTreeFormWhenConstructedFromTwoSeparateListsAreCombined() throws CouldNotHandleException {
        cHandler
                .addToChain(aaHandler)
                .addToChain(bHandler);
        aHandler
                .addToChain(bbHandler)
                .addToChain(baHandler);
        cHandler.head().addToChain(aHandler);
        assertEquals(expected, cHandler.handleFromHead(input));
    }

    @Test
    public void testThatWhenLinksAreAddedInTheWrongOrderTheyReorderThemselves() throws CouldNotHandleException {
        bHandler.addToChain(aHandler);
        assertEquals(1, bHandler.handleFromHead("a").intValue());
    }

    @Test
    public void testThatWhenAddingAHandlerThatIsAlreadyPartOfAChainTheRestOfItsChainIsIntegratedIntoTheCurrentOne() throws CouldNotHandleException {
        aaHandler.addToChain(bHandler);
        aHandler.addToChain(aaHandler);
        assertEquals(2, aHandler.handleFromHead("b").intValue());
    }
}