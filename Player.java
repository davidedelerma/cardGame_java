import java.util.*;

public class Player {

  private String name;
  private ArrayList<Card> hand;

  public Player(String name){
    this.name = name;
    this.hand = new ArrayList<Card>();
  }

  public String getName(){
    return this.name;
  }

  public void setHand(Card card){
    this.hand.add(card);
  }

  public ArrayList<Card> getHand(){
    return this.hand;
  }

  public String printHand(){
    return this.hand.get(1).toString() + ", " + this.hand.get(1).toString() + ", " + this.hand.get(1).toString();
  }
}