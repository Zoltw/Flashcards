package org.flashcards.src;

public class NormalState implements State{

    @Override
    public void action() {
        System.out.println("I'm a normal flashcard!");
    }
}
