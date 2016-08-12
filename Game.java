import java.util.*;

public class Game {

  private ArrayList<Player> players = new ArrayList<Player>();
  private DeckFactory factory;
  private Deck deck;
  //private WinChecker winChecker = new WinChecker();

  public void buildDeck(){
    factory = new DeckFactory();
    deck = factory.buildDeck();
  }

  public void shuffleDeck(){
    deck.shuffle();
  }

  public Deck getDeck(){
    return this.deck;
  }

  public void addPlayer(Player player){
    players.add(player);
  }

  public int playerCount(){
    return players.size();
  }

  public void deal(){
    for (Player player : this.players){
      for (int i = 0; i < 3;i++){
        Card card = deck.pick();
        player.setHand(card);
      }

    } 
  }

}