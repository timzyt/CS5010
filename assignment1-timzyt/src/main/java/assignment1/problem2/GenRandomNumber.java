package assignment1.problem2;

import java.util.Random;

/**
 * Created by timzyt on 9/12/2018. GenRandomNumber class uses for generating a random integer
 * between 0 and provided range.
 */
public class GenRandomNumber {

  /*****************************************************************************************
   *  * GenRandomNumber method
   *  * -generate a random number within range [0, range].
   *  * -include 0 and range.
   *
   * @param range the range this random number is in.
   * @return int the integer random number.
   */
  public int genRandNum(int range) {
    range += 1;
    Random ran = new Random();
    int randomNumber = ran.nextInt(range);
    return randomNumber;
  }
}
