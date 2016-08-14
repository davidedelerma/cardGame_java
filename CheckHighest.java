import java.util.*;


public class CheckHighest {

  private Card[] hand;

  public CheckHighest(){

  } 

  public int check(Card[] hand){


    int max = hand[0].getValue();
    for (int i = 1; i < hand.length; i++ ){
      if(hand[i].getValue() == 1){
        return max = 14;
      } else {
        if(hand[i].getValue() > max){
          max = hand[i].getValue();
        }
      }
    }
    return max;

  }
}