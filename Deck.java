import java.util.*;

public class Deck {
  private int nbOfCards;
  private Card[] cards;
  private int cardsUsed;

  public Deck(int nbOfCards) {
    this.nbOfCards = nbOfCards;
    this.cards = new Card[nbOfCards];
  }

  public int cardCount(){
    int count = 0;
    for (Card card : cards){
      if (card!=null){
        count++;
      }
    }
    return count;
  }
  public void addCard(Card card) {
    int cardCount = cardCount();
    this.cards[cardCount] = card;
  }

  public int cardsLeft() {
      return cards.length - cardsUsed;
  }

  public void shuffle() {
    for ( int i = nbOfCards-1; i > 0; i-- ) {
      int rand = (int)(Math.random()*(i+1));
      Card temp = cards[i];
      cards[i] = cards[rand];
      cards[rand] = temp;
    }
    cardsUsed = 0;
  }


  public Card pick() throws IllegalStateException {
    if (cardsUsed == cards.length){
      throw new IllegalStateException ("No cards are left in the deck.");
    }
    cardsUsed++;
    return cards[cardsUsed - 1];
        // Programming note:  Cards are not literally removed from the array
        // that represents the deck.  We just keep track of how many cards
        // have been used.
  }


}