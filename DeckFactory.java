import java.util.*;

public class DeckFactory {

  public Deck buildDeck(){
    Deck deck = new Deck(3);
    deck.addCard(new Card(1, CardType.DIAMONDS));
    deck.addCard(new Card(4, CardType.SPADES));
    deck.addCard(new Card(8, CardType.HEARTS));

    return deck;
  }

}

