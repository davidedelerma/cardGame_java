import java.util.*;

public class Runner{

  DeckFactory factory;
  Deck deck;
  Game game;
  Player player1;
  Player player2;

  public Runner (){
    //refactoring using a Viewer class
    factory = new DeckFactory();
    deck = factory.buildDeck();
    deck.shuffle();
    game = new Game(deck);
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter player 1 name: ");
    String p1Name = scanner.next();
    player1 = new Player(p1Name); //could be improved adding a setName method to player;
    System.out.print("Enter player 2 name: ");
    String p2Name = scanner.next();
    player2 = new Player(p2Name);
    game.addPlayer(player1);
    game.addPlayer(player2);    
    System.out.println("So Far So Good");

  }
  public void turns(){
    System.out.println("turn working");
    int count = 0;
    while (game.deal() == true){
      System.out.print(player1.printHand());
      System.out.print("\n");
      System.out.print(player2.printHand());
      System.out.print("\n");
      game.pointsChecker();
      game.defineWinner();
      System.out.format("nb of %s wins : %d ; nb of %s wins : %d  ", player1.getName(), player1.getWin(),player2.getName(), player2.getWin());
      System.out.print("\n");
      game.resetPoints();
    }
  }

  public static void main(String[] args){
    new Runner().turns();    
  }

}