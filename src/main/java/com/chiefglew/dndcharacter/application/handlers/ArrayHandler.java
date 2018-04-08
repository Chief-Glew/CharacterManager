package com.chiefglew.dndcharacter.application.handlers;

import com.chiefglew.dndcharacter.ListLinker;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

public abstract class ArrayHandler<ReturnType, ArrayType extends Comparable<ArrayType>> implements ListLinker<ArrayHandler<ReturnType, ArrayType>>, GetXFromYHandler<ReturnType, ArrayType[]> {

    private int position;
    private ArrayType[] array;

    private ArrayHandler<ReturnType, ArrayType> previous;
    private ArrayHandler<ReturnType, ArrayType> primary;
    private ArrayHandler<ReturnType, ArrayType> secondary;

    public ArrayHandler(ArrayType[] array) {
        this(0, array);
    }

    public ArrayHandler(int position, ArrayType[] array) {
        this.position = position;
        this.array = array;
    }

    @Override
    public abstract ReturnType handle(ArrayType[] arrayTypes) throws CouldNotHandleException;

    public ReturnType handleFromHead(ArrayType[] arrayTypes) throws CouldNotHandleException {
        return head().handle(arrayTypes);
    }

    public ArrayHandler<ReturnType, ArrayType> head() {
        if (previous != null) {
            return previous.head();
        }
        return this;
    }

    @Override
    public ReturnType handleNext(@NotNull ArrayType[] arrayTypes) throws CouldNotHandleException {
        if (arrayTypes.length < position+1) {
            throw new CouldNotHandleException("the given array (" + arrayTypes + ") was not able to be handled");
        }

        if (Arrays.equals(this.array,arrayTypes))
            return handlerMethod(arrayTypes);

        if (this.array[position].equals(arrayTypes[position])) {
            return handleSecondary(arrayTypes);
        }
        else{
            return handlePrimary(arrayTypes);
        }
    }

    @Override
    public ArrayHandler<ReturnType, ArrayType> addToChain(ArrayHandler<ReturnType, ArrayType> handler) {
        ArrayHandler<ReturnType, ArrayType> head;
        if (Arrays.equals(this.array,handler.array))
            return head();
        if (handlerArrayMatchesThisUpToPointer(handler.array)) {
            if (thisComesBeforeThat(handler)) {
                head = addToSecondary(handler);
            } else {
                head = replaceMe(handler);
            }
        }
        else{
            if (thisComesBeforeThat(handler)) {
                head = addToPrimary(handler);
            } else {
                head = replaceMe(handler);
            }
        }
        if (handler.primary != null) {
            head = passUpToAddToChain(handler.primary);
        }
        if (handler.secondary != null) {
            head = passUpToAddToChain(handler.secondary);
        }
        return head==null ? head():head;
    }

    private ArrayHandler<ReturnType, ArrayType> passUpToAddToChain(ArrayHandler<ReturnType, ArrayType> handler) {
        if (previous !=null && !handlerArrayMatchesThisUpToPointer(handler.array)){
            return previous.passUpToAddToChain(handler);
        }
        else {
            return addToChain(handler);
        }
    }

    private boolean handlerArrayMatchesThisUpToPointer(ArrayType[] array) {
        boolean matches = true;
        int pointer = Integer.min(position, array.length-1);
        for (int i = 0; i <= pointer; i++) {
            try {
                matches &= this.array[pointer].equals(array[pointer]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                }
        }
        return matches;
    }

    private boolean thisComesBeforeThat(ArrayHandler<ReturnType, ArrayType> handler) {
        int pointer = 0;
        int difference = 0;
        ArrayType[] shortestArray = array.length<handler.array.length ? array : handler.array;
        while (difference == 0 && pointer<shortestArray.length){
            difference=array[pointer].compareTo(handler.array[pointer]);
            pointer++;
        }
        if (difference==0){
            return Arrays.equals(array, shortestArray);
        }
        else{
            return difference<0;
        }
    }

    private ArrayHandler<ReturnType, ArrayType> addToPrimary(ArrayHandler<ReturnType, ArrayType> handler) {
        if (primary == null) {
            primary = handler;
            handler.previous = this;
            return head();
        }
        else{
            return primary.addToChain(handler);
        }
    }

    private ArrayHandler<ReturnType, ArrayType> addToSecondary(ArrayHandler<ReturnType, ArrayType> handler) {
        if (secondary == null) {
            secondary = handler;
            handler.previous = this;
            handler.position = position+1;
            return head();
        }
        else{
            return secondary.addToChain(handler);
        }
    }

    private ArrayHandler<ReturnType, ArrayType> replaceMe(ArrayHandler<ReturnType, ArrayType> handler) {
        if (previous != null)
            previous.replaceThisWithThat(this, handler);
        handler.previous=previous;
        handler.position = position;
        ArrayHandler<ReturnType, ArrayType> temp;

        temp = handler.primary;
        handler.primary = primary;
        primary=temp;

        temp = handler.secondary;
        handler.secondary = secondary;
        secondary=temp;
        return handler.addToChain(this);
    }

    private void replaceThisWithThat(ArrayHandler<ReturnType, ArrayType> thisHandler, ArrayHandler<ReturnType, ArrayType> thatHandler) {
        if (primary==thisHandler)
            primary=thatHandler;
        if (secondary==thisHandler)
            secondary=thatHandler;
    }

    private ReturnType handlePrimary(ArrayType[] arrayTypes) throws CouldNotHandleException {
        if (primary == null) {
            throw new CouldNotHandleException("the given array (" + arrayTypes + ") was not able to be handled");
        }
        return primary.handle(arrayTypes);
    }

    private ReturnType handleSecondary(ArrayType[] arrayTypes) throws CouldNotHandleException {
        if (secondary == null) {
            throw new CouldNotHandleException("the given array (" + arrayTypes + ") was not able to be handled");
        }
        return secondary.handle(arrayTypes);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ArrayHandler{");
        sb.append("position=").append(position);
        sb.append(", array=").append(array == null ? "null" : Arrays.asList(array).toString());
        sb.append(", primary=").append(primary);
        sb.append(", secondary=").append(secondary);
        sb.append('}');
        return sb.toString();
    }
}
