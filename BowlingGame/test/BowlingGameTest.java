/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bowlinggame.BowlingGame;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Mattia
 */
public class BowlingGameTest {
    
  BowlingGame game;
 
@Before
 public void setUp() throws Exception {
    game = new BowlingGame();
  }

   
 @Test
 public void canRoll() {
     
     rollMany(0,20);
     assertEquals(0, game.getScore());
 }
 
 @Test
 public void canRollAllOnes() {
     rollMany(1,20);
     assertEquals(20, game.getScore());
 }
  
 
 private void rollMany(int pins, int rolls) {
     for(int i=0; i<rolls; i++) {
         game.roll(pins);
     }
 }
 
 @Test
 public void testOneSpare() throws Exception {
    game.roll(5);
    game.roll(5); // spare
    game.roll(3);
    rollMany(17,0);
   assertEquals(16,game.getScore());
 }
 
 @Test
  public void testOneStrike() throws Exception {
    rollStrike();
    game.roll(3);
    game.roll(4);
    rollMany(16, 0);
    assertEquals(24, game.getScore());
  }

 @Test 
  public void testPerfectGame() throws Exception {
    rollMany(10,12);
    assertEquals(300, game.getScore());
  }

  @Test
  public void rollStrike() {
    game.roll(10);
  }

  @Test
  public void rollSpare() {
    game.roll(5);
    game.roll(5);
  }


 
  }


