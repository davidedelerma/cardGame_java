import java.util.*;

public class Card {

  private int value;
  private CardType suit;

  public Card(int value, CardType suit) {
    this.value = value;
    this.suit = suit;
  }

  public CardType getSuit(){
    return this.suit;
  }
  
  public int getValue(){
    return this.value;
  }

}