package edu.cnm.deepdive.cards.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Deck {

  private final List<Card> cards;

  public Deck() {
    cards = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        Card card = new Card(rank, suit);
        cards.add(card);
      }
    }
  }

  public void shuffle(RandomGenerator rng) {
    Collections.shuffle(cards, rng);

  }

  public void sort() {
    cards.sort(null);
  }
  @Override
  public String toString() {
    return cards.toString();
  }

}
