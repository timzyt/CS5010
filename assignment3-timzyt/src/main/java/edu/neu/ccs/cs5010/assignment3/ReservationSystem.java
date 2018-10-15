package edu.neu.ccs.cs5010.assignment3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ReservationSystem {

  /**
   * The main class.
   *
   * @author timzyt. created on 2018/10/01.
   */
  public static void main(String[] args) throws Exception {
    String theaterName = "Roxy";
    Integer nrow = Integer.valueOf(15);
    Integer nseat = Integer.valueOf(20);
    Integer rowNum;
    Integer globalCounter = Integer.valueOf(0);
    Integer getNameInputCounter = Integer.valueOf(0);
    Integer groupSize;
    String needAccessibility;
    String yes = "yes";
    Integer numOfTrial = Integer.valueOf(3);
    HashSet<Integer> accessibility = new HashSet<>();

    accessibility.add(Integer.valueOf(2));
    accessibility.add(Integer.valueOf(10));
    Theater newTheater = new Theater(theaterName, nrow, nseat, accessibility);
    ReservationsService newrs = new ReservationsService(newTheater);
    Scanner scannerGroupSize = new Scanner(System.in, "UTF-8");
    while (globalCounter < numOfTrial) {
      System.out.println("What would you like to do?" + " globalCounter " + globalCounter
          + ", getNameInputCounter " + getNameInputCounter);
      String reserveCommand = scannerGroupSize.nextLine();
      String[] splitCommand = reserveCommand.split(" ");
      String first = splitCommand[0];
      String[] trailing = Arrays.copyOfRange(splitCommand, 1, splitCommand.length);
      if (first.contentEquals("reserve") && splitCommand[1].matches("[0-9]+")
          && splitCommand.length == 2) {
        groupSize = Integer.valueOf(splitCommand[1]);
        System.out.println("Do you need wheelchair accessible seats? (yes/no)");
        needAccessibility = scannerGroupSize.nextLine();
        if (needAccessibility.contentEquals(yes)) {
          rowNum = newrs.findBestRow(groupSize, true);
        } else {
          rowNum = newrs.findBestRow(groupSize, false);
        }
        if (rowNum == null) {
          System.out.println("Sorry, we don't have that many seats together for you.");
          continue;
        } else {
          while (getNameInputCounter < numOfTrial) {
            // Scanner scannerClientName = new Scanner(System.in, "UTF-8");
            System.out.println("What's your name?");
            String clientName = scannerGroupSize.nextLine();
            if (!clientName.matches("[a-zA-Z]+")) {
              getNameInputCounter += 1;
              if (getNameInputCounter > 0 && getNameInputCounter < numOfTrial) {
                System.out.println("Please try again.");
              } else {
                System.out.println("Sorry, trial exceeded allowed limit.");
                System.exit(0);
              }
            } else {
              newrs.reserveSeats(clientName, rowNum, groupSize);
              System.out.println(
                  "I've reserved " + groupSize + " seats for you at the " + theaterName + " in row "
                      + rowNum + ", " + clientName + ".");
              //getNameInputCounter = numOfTrial;
              break;
            }
          }
        }
      } else if (reserveCommand.contentEquals("show")) {
        System.out.println(newrs.showMap());
      } else if (reserveCommand.contentEquals("done")) {
        System.out.println("Have a nice day!");
        System.exit(0);
      } else {
        globalCounter++;
        if (globalCounter > 0 && globalCounter < numOfTrial) {
          System.out.println("Please try again.");
        } else {
          System.out.println("Sorry, trial exceeded allowed limit.");
          System.exit(0);
        }
      }
    }
  }
}
