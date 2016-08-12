import static org.junit.Assert.*;
import org.junit.*;
//import org.mockito.*;
//import static org.mockito.Mockito.*;

public class GameTest {

  DeckFactory factory;
  Deck deck;
  Player player;
  @Before
  public void before(){
    factory = new DeckFactory();
    deck = factory.buildDeck();
    player = new Player("davide");
  }
 
  @Test
  public void canCreateDeck(){
    assertEquals (52, deck.cardCount());
  }
  
  @Test
  public void canPickCard(){
    Card card = deck.pick();
    assertEquals(CardType.SPADES, card.getSuit());
    assertEquals(1, card.getValue());
  }

  @Test
  public void canGetPlayerName(){
    assertEquals("davide",player.getName());
  }
  
  // @Test
  // public void canShuffle(){
  //   deck.shuffle();
  //   System.out.println(deck);
  // }
}