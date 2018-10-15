package assignment1.problem4;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by timzyt on 9/14/2018. GenRandomNumber class uses for generating a random integer
 * between provided input min and max.
 */
public class GenRandomNumber {

  /*****************************************************************************************
   *  * GenRandomNumber method
   *  * -generate a random number within range [min, max].
   *  * -include min and max.
   *
   * @param min minimum value for this random number.
   * @param max maximum value for this random number.
   * @return a random number between the range of minimum and maximum.
   */
  public double genRandNum(Integer min, Integer max) {
    Random random = new Random();
    double randomNumber = min + (max - min + 1) * random.nextDouble();
    return randomNumber;
  }
}
