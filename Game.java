import java.util.*;

public class Game {

  private ArrayList<Player> players = new ArrayList<Player>();
  private Deck deck;
  private CheckPrial prial = new CheckPrial();
  private CheckRunningFlush runningFlush = new CheckRunningFlush();
  private CheckRun run = new CheckRun();
  private CheckFlush flush = new CheckFlush();
  private CheckPair pair = new CheckPair();
  private CheckHighest highestP1 = new CheckHighest();
  private CheckHighest highestP2 = new CheckHighest();

  public Game(Deck deck){
    this.deck = deck;
  }

  public Deck getDeck(){
    return this.deck;
  }

  public void addPlayer(Player player){
    players.add(player);
  }

  public ArrayList<Player> getPlayers(){
    return this.players;
  }

  public int playerCount(){
    return players.size();
  }

  public boolean deal(){
    try {
      for (Player player : players){
        Card card1 = this.deck.pick();
        Card card2 = this.deck.pick();
        Card card3 = this.deck.pick();
        player.setHand(card1, card2, card3);
      }
      return true;
    }
    catch (IllegalStateException ex){
      ex.printStackTrace();
      System.out.println("Exception message: ");
      System.out.println(ex.getMessage());
      return false;
    }
  }

  public void pointsChecker(){
    for (Player player : players){
      if (prial.check(player.getHand())) {
        player.setPoints(5);
      } else if (runningFlush.check(player.getHand())){
        player.setPoints(4);
      } else if (run.check(player.getHand())){
        player.setPoints(3);
      } else if (flush.check(player.getHand())){
        player.setPoints(2);
      } else if (pair.check(player.getHand())){
        player.setPoints(1);
      }
    }
  }
// improve define winner function to work for any number of players: in that case create an array of points, find the maximum value of the array, take the index and players.get(i) is the winner.... then write the function in case of no winning(draws)
  public void defineWinner(){
    Player player1 = players.get(0);
    Player player2 = players.get(1);

    if (player1.getPoints() > player2.getPoints()){

      players.get(0).win();

    } else if (player1.getPoints() > player2.getPoints()){

      players.get(1).win();

    } else if (player1.getPoints() == player2.getPoints()){

      if( highestP1.check(player1.getHand()) > highestP2.check(player2.getHand()) ){

        players.get(0).win();

      } else if (highestP1.check(player1.getHand()) < highestP2.check(player2.getHand())){

        players.get(1).win();

      }
    }
  }

  public void resetPoints(){
    for (Player player : players){
      player.setPoints(0);
    }
  }


}