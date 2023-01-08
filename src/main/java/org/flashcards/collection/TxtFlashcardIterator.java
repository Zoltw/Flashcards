package org.flashcards.collection;

import org.flashcards.src.Flashcard;

public class TxtFlashcardIterator implements Iterator {
    private final TxtFlashcardCollection list;
    private int iterationPosition;

    public TxtFlashcardIterator(TxtFlashcardCollection list) {
        this.list = list;
        this.iterationPosition = -1;
    }

    @Override
    public Flashcard next() {
        if (!isDone()) {
            iterationPosition += 1;
            return list.getList().get(iterationPosition);
        }
        return null;
    }

    @Override
    public boolean isDone() {
        return list.getList().size() <= iterationPosition;
    }
}
