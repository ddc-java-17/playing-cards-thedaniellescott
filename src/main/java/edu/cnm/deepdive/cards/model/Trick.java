package edu.cnm.deepdive.cards.model;

import edu.cnm.deepdive.cards.model.Suit.Color;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.random.RandomGenerator;

public class Trick {

  private final List<Card> blackPile;
  private final List<Card> redPile;

  public Trick(RandomGenerator rng) {
    blackPile = new LinkedList<>();
    redPile = new LinkedList<>();
    Deck deck = new Deck();
    deck.shuffle(rng);
    split(deck);
  }

  public void swap(int numberToSwap) throws IllegalArgumentException {
    if (numberToSwap > blackPile.size() || numberToSwap > redPile.size()) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < numberToSwap; i++) {
      blackPile.add(redPile.removeFirst());
      redPile.add(blackPile.removeFirst());
    }
  }

  public List<Card> getBlackPile() {
    return Collections.unmodifiableList(blackPile);
  }

  public List<Card> getRedPile() {
    return Collections.unmodifiableList(redPile);
  }
  private void split(Deck deck) {
    while (!deck.isEmpty()) {
      Card selector = deck.draw();
      Card next = deck.draw();
      if (selector.suit().color() == Color.BLACK) {
        blackPile.add(next);
      } else {
        redPile.add(next);
      }
    }
  }

}
