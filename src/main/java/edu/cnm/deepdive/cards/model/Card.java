package edu.cnm.deepdive.cards.model;

public record Card(Rank rank, Suit suit) implements Comparable<Card> {

  public Card(Card other) {
    this(other.rank, other.suit);
  }

  @Override
  public int compareTo(Card other) {
    int comparison = this.suit.compareTo(other.suit);
    if (comparison == 0) {
      comparison = this.rank.compareTo(other.rank);
    }
    return comparison;
  }

}
