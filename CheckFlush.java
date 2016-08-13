import java.util.*;


public class CheckFlush {

  private Card[] hand;

  public CheckFlush(){

  } 

  public boolean check(Card[] hand){
    int count=0;
    for (int i = 1; i < hand.length; i++ ){
      if(hand[i].getSuit() == hand [i-1].getSuit() && hand[i].getValue() != (hand [i-1].getValue()) +1){
        count ++;
      }
    }
    if (count == 2){
      return true;
    } else {
      return false;
    }
  }
}