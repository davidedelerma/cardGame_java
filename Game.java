import java.util.*;

public class Game {

  private ArrayList<Player> players = new ArrayList<Player>();
  private DeckFactory factory;
  private Deck deck;

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

  public void deal(Player player){
    Card card1 = this.deck.pick();
    Card card2 = this.deck.pick();
    Card card3 = this.deck.pick();
    player.setHand(card1, card2, card3);
  }


}