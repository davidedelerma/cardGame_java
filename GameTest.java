import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.*;
import static org.mockito.Mockito.*;

public class GameTest {

 @Before
 public void before(){
  DeckFactory factory = new DeckFactory();
  Deck deck = factory.buildDeck();
 }
 @Test
 public void canCreateDeck(){
  assertEquals (3, deck.cardCount());
 }

}