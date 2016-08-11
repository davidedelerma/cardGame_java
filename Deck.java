import java.util.*;

public class Deck {
  private int nbOfCards;
  private Card[] cards;

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

  private int randomNumber(int min, int max){
    Random rand = new Random();
    int result = rand.nextInt((max-min) + 1) + min;
    return result;
  }

  public int randomInt(){
    return randomNumber(1, this.nbOfCards);
  }
  public Card pick(){
    return this.cards[randomInt()];
  }
}