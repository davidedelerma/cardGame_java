import java.util.*;


public class CheckPrial {

  private Card[] hand;

  public CheckPrial(){

  } 

  public boolean check(Card[] hand){
    int count=0;
    for (int i = 1; i < hand.length; i++ ){
      if(hand[i].getValue() == hand [i-1].getValue()){
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