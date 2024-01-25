package edu.cnm.deepdive.cards;

import edu.cnm.deepdive.cards.model.Deck;
import java.security.SecureRandom;

public class Main {

  public static void main(String[] args) {
    Deck deck = new Deck();
    System.out.println(deck);
    deck.shuffle(new SecureRandom());
    System.out.println(deck);
    deck.sort();
    System.out.println(deck);
    // TODO: 1/25/2024 Execute cool card trick
  }

}
