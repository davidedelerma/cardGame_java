import java.util.*;


public class CheckPair {

  private Card[] hand;

  public CheckPair(){

  } 

  public boolean check(Card[] hand){
    int count=0;
    for (int i = 1; i < hand.length; i++ ){
      if(hand[i].getValue() == hand [i-1].getValue()){
        count ++;
      }
    }
    if (count == 1){
      return true;
    } else {
      return false;
    }
  }
}