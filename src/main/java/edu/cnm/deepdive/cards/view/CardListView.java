package edu.cnm.deepdive.cards.view;

import edu.cnm.deepdive.cards.model.Card;
import edu.cnm.deepdive.cards.model.Suit;
import edu.cnm.deepdive.cards.model.Suit.Color;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CardListView {

  private static final Comparator<Card> CARD_COLOR_COMPARATOR = Comparator.comparing(Card::suit, Comparator.comparing(
      Suit::color))
      .thenComparing(Card::suit)
      .thenComparing(Card::rank);
  private static final String PILE_FORMAT = "%1$s pile: %2$s; %3$d %1$s cards.";

  public String render(List<Card> cards, Color color) {
    String pileContents =  cards
        .stream()
        .sorted(CARD_COLOR_COMPARATOR)
        .map(Card::toString)
        .collect(Collectors.joining(" "));
    int colorCount = 0;
    for (Card card : cards) {
      if (card.suit().color() == color) {
        colorCount++;
      }
    }
    return PILE_FORMAT.formatted(color, pileContents, colorCount);
  }

}
