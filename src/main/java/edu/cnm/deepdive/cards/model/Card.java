package edu.cnm.deepdive.cards.model;

import java.util.Comparator;

public record Card(Rank rank, Suit suit) implements Comparable<Card> {

  private static final Comparator<Card> CARD_COMPARATOR = Comparator.comparing(Card::suit)
      .thenComparing(Card::rank);

  public Card(Card other) {
    this(other.rank, other.suit);
  }

  @Override
  public int compareTo(Card other) {

    /*int comparison = this.suit.compareTo(other.suit);
    if (comparison == 0) {
      comparison = this.rank.compareTo(other.rank);
    }
    return comparison;*/

    return CARD_COMPARATOR.compare(this, other);
  }

  @Override
  public String toString() {
    return rank.symbol() + suit.symbol();
  }
}
