/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlinggame;

/**
 *
 * @author Mattia
 */
public class BowlingGame {

  private int[] rolls = new int[21]; 
  private int currentRoll = 0;
    
  private int score = 0;  
  
    
  public void roll(int pins){
      score += pins;
      rolls[currentRoll++] = pins;
  }
  
  public int getScore() {
    int score = 0;
    int frameIndex = 0;
    for (int frame = 0; frame < 10; frame++) {
      if (isStrike(frameIndex)) {
        score += 10 + strikeBonus(frameIndex);
        frameIndex++;
      } else if (isSpare(frameIndex)) {
        score += 10 + spareBonus(frameIndex);
        frameIndex += 2;
      } else {
        score += sumOfBallsInFrame(frameIndex);
        frameIndex += 2;
      }
    }
    return score;
  }

  private boolean isStrike(int frameIndex) {
    return rolls[frameIndex] == 10;
  }

  private int sumOfBallsInFrame(int frameIndex) {
    return rolls[frameIndex] + rolls[frameIndex+1];
  }

  private int spareBonus(int frameIndex) {
    return rolls[frameIndex+2];
  }

  private int strikeBonus(int frameIndex) {
    return rolls[frameIndex+1] + rolls[frameIndex+2];
  }

  private boolean isSpare(int frameIndex) {
    return rolls[frameIndex]+rolls[frameIndex+1] == 10;
  }

}
