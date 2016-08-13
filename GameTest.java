import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;
//import org.mockito.*;
//import static org.mockito.Mockito.*;

public class GameTest {

  DeckFactory factory;
  Deck deck;
  Player player;
  Game game;
  CheckPrial prial;
  CheckRunningFlush runningFlush;
  CheckRun run;
  CheckFlush flush;
  CheckPair pair;

  @Before
  public void before(){
    factory = new DeckFactory();
    deck = factory.buildDeck();
    player = new Player("davide");
    game = new Game(deck);
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

  @Test
  public void playerCanSetHand(){
    Card card1 = this.deck.pick();
    Card card2 = this.deck.pick();
    Card card3 = this.deck.pick();
    player.setHand(card1, card2, card3);
    Card[] hand = player.getHand();
    Card testCard1 = hand[0];
    Card testCard2 = hand[1];
    Card testCard3 = hand[2];    
    assertEquals(1, testCard1.getValue());
    assertEquals(2, testCard2.getValue());
    assertEquals(3, testCard3.getValue());
  }

  @Test
  public void canAddPlayerToGame(){
    game.addPlayer(player);
    ArrayList<Player> players = game.getPlayers();
    Player playerTest = players.get(0);
    assertEquals("davide",playerTest.getName());
  } 

  @Test
  public void gameCanDealCards(){

    game.deal(player);
    Card[] hand = player.getHand();
    Card testCard1 = hand[0];
    Card testCard2 = hand[1];
    Card testCard3 = hand[2];    
    assertEquals(1, testCard1.getValue());
    assertEquals(2, testCard2.getValue());
    assertEquals(3, testCard3.getValue());
  }

  @Test
  public void isPrial(){
    Card card1 = new Card(1, CardType.SPADES);
    Card card2 = new Card(1, CardType.HEARTS);
    Card card3 = new Card(1, CardType.DIAMONDS);
    player.setHand(card1, card2, card3);
    Card[] hand = player.getHand();
    prial = new CheckPrial();
    assertEquals(true, prial.check(hand));
  }

  @Test
  public void isPair(){
    Card card1 = new Card(1, CardType.SPADES);
    Card card2 = new Card(1, CardType.HEARTS);
    Card card3 = new Card(2, CardType.DIAMONDS);
    player.setHand(card1, card2, card3);
    Card[] hand = player.getHand();
    pair = new CheckPair();
    assertEquals(true, pair.check(hand));
  }

  @Test
  public void isNotPair(){
    Card card1 = new Card(1, CardType.SPADES);
    Card card2 = new Card(1, CardType.HEARTS);
    Card card3 = new Card(1, CardType.DIAMONDS);
    player.setHand(card1, card2, card3);
    Card[] hand = player.getHand();
    pair = new CheckPair();
    assertEquals(false, pair.check(hand));
  }

  @Test
  public void isNotPrial(){
    Card card1 = new Card(1, CardType.SPADES);
    Card card2 = new Card(1, CardType.HEARTS);
    Card card3 = new Card(2, CardType.DIAMONDS);
    player.setHand(card1, card2, card3);
    Card[] hand = player.getHand();
    prial = new CheckPrial();
    assertEquals(false, prial.check(hand));
  }

  @Test
  public void isRunningFlush(){
    Card card1 = new Card(1, CardType.SPADES);
    Card card2 = new Card(2, CardType.SPADES);
    Card card3 = new Card(3, CardType.SPADES);
    player.setHand(card1, card2, card3);
    Card[] hand = player.getHand();
    runningFlush = new CheckRunningFlush();
    assertEquals(true, runningFlush.check(hand));
  }

  @Test
  public void isRun(){
    Card card1 = new Card(1, CardType.SPADES);
    Card card2 = new Card(2, CardType.HEARTS);
    Card card3 = new Card(3, CardType.DIAMONDS);
    player.setHand(card1, card2, card3);
    Card[] hand = player.getHand();
    run = new CheckRun();
    assertEquals(true, run.check(hand));
  }

  @Test
  public void isNotRun(){
    Card card1 = new Card(1, CardType.SPADES);
    Card card2 = new Card(2, CardType.SPADES);
    Card card3 = new Card(3, CardType.SPADES);
    player.setHand(card1, card2, card3);
    Card[] hand = player.getHand();
    run = new CheckRun();
    assertEquals(false, run.check(hand));
  }

  @Test
  public void isNotFlush(){
    Card card1 = new Card(1, CardType.SPADES);
    Card card2 = new Card(2, CardType.SPADES);
    Card card3 = new Card(3, CardType.SPADES);
    player.setHand(card1, card2, card3);
    Card[] hand = player.getHand();
    flush = new CheckFlush();
    assertEquals(false, flush.check(hand));
  }

  @Test
  public void isFlush(){
    Card card1 = new Card(4, CardType.SPADES);
    Card card2 = new Card(8, CardType.SPADES);
    Card card3 = new Card(10, CardType.SPADES);
    player.setHand(card1, card2, card3);
    Card[] hand = player.getHand();
    flush = new CheckFlush();
    assertEquals(true, flush.check(hand));
  }

}




