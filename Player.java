import java.util.*;

public class Player {

  private String name;
  private Card[] hand;
  private int points;
  private int winning;

  public Player(String name){
    this.name = name;
    this.hand = new Card[3];
    this.points = 0;
    this.winning = 0;
  }

  public String getName(){
    return this.name;
  }

  public int getPoints(){
    return this.points;
  }

  public int getWin(){
    return this.winning;
  }

  public void win(){
    this.winning++;
  }
  public void setPoints(int points){
    this.points = points;
  }

  public void setHand(Card card1, Card card2, Card card3){
    this.hand[0] = card1;
    this.hand[1] = card2;
    this.hand[2] = card3;
  }

  public Card[] getHand(){
    return this.hand;
  }

  public String printHand(){
    return String.format("The cards in hand of %s are: %d %s , %d %s , %d %s ", this.name, this.hand[0].getValue(), this.hand[0].getSuit().toString(), this.hand[1].getValue(), this.hand[1].getSuit().toString(),this.hand[2].getValue(), this.hand[2].getSuit().toString());
  }
}