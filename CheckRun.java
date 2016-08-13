import java.util.*;


public class CheckRun {

  private Card[] hand;

  public CheckRun(){

  } 

  public boolean check(Card[] hand){
    int count=0;
    for (int i = 1; i < hand.length; i++ ){
      if(hand[i].getValue() == (hand [i-1].getValue()) +1 && hand[i].getSuit() != hand [i-1].getSuit()){
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