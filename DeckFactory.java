import java.util.*;

public class DeckFactory {

  int cardCt;
  int value;
  int suit; 
  Deck deck;
  
  public Deck buildDeck(){
    Deck deck = new Deck(52);
    int cardCt = 0; // How many cards have been created so far.
    for ( CardType type : CardType.values() ) {
      for ( int value = 1; value <= 13; value++ ) {
        deck.addCard(new Card(value, type));
        cardCt++;
      }
    }

    return deck;
  }
}

