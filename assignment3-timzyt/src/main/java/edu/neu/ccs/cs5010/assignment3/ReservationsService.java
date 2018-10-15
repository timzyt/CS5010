package edu.neu.ccs.cs5010.assignment3;

/**
 * The class Reservation Service.
 *
 * @author timzyt. created on 2018/10/01.
 */
public class ReservationsService {

  private Theater theater;

  /**
   * Instantiates a new reservations service.
   *
   * @param atheater a theater.
   */
  public ReservationsService(Theater atheater) {
    this.theater = atheater;
  }

  /**
   * Find best row integer.
   *
   * @param groupSize the group size.
   * @return Integer the row number of the best row.
   */
  public Integer findBestRow(Integer groupSize, Boolean needAccessible) {
    if (groupSize < 0) {
      throw new InvalidConstructorArgumentException("Provided group size is invalid.");
    }
    Integer midRowNumber;
    if (needAccessible) {
      if (this.theater.getNumOfRow() % 2 == 0) {
        midRowNumber = this.theater.getNumOfRow() / 2 - 1;
        for (int i = 0; i <= (this.theater.getNumOfRow() / 2 - 1); i++) {
          if (this.theater.getAccessibleRows().contains(Integer.valueOf(midRowNumber - i + 1))
              && this.theater.getTheaterMap().get(midRowNumber - i).getEmptySeat() >= groupSize) {
            //return the actual reserved row number as oppose to index of the row.
            return midRowNumber - i + 1;
          } else if (
              this.theater.getAccessibleRows().contains(Integer.valueOf(midRowNumber + 1 + i + 1))
                  && this.theater.getTheaterMap().get(midRowNumber + 1 + i).getEmptySeat()
                  >= groupSize) {
            return midRowNumber + 1 + i + 1;
          } else {
            continue;
          }
        }
      } else {
        midRowNumber = this.theater.getNumOfRow() / 2;
        if (this.theater.getAccessibleRows().contains(Integer.valueOf(midRowNumber + 1))
            && this.theater.getTheaterMap().get(midRowNumber).getEmptySeat() >= groupSize) {
          //return the actual reserved row number as oppose to index of the row.
          return midRowNumber + 1;
        } else {
          for (int i = 0; i <= this.theater.getNumOfRow() / 2; i++) {
            if (this.theater.getAccessibleRows().contains(Integer.valueOf(midRowNumber - i + 1))
                && this.theater.getTheaterMap().get(midRowNumber - i).getEmptySeat() >= groupSize) {
              return midRowNumber - i + 1;
            } else if (
                this.theater.getAccessibleRows().contains(Integer.valueOf(midRowNumber + i + 1))
                    && this.theater.getTheaterMap().get(midRowNumber + i).getEmptySeat()
                    >= groupSize) {
              return midRowNumber + i + 1;
            } else {
              continue;
            }
          }
        }
      }
      return null;
    } else {
      if (this.theater.getNumOfRow() % 2 == 0) {
        midRowNumber = this.theater.getNumOfRow() / 2 - 1;
        for (int i = 0; i <= (this.theater.getNumOfRow() / 2 - 1); i++) {
          if (!this.theater.getAccessibleRows().contains(Integer.valueOf(midRowNumber - i + 1))
              && this.theater.getTheaterMap().get(midRowNumber - i).getEmptySeat() >= groupSize) {
            //return the actual reserved row number as oppose to index of the row.
            return midRowNumber - i + 1;
          } else if (
              !this.theater.getAccessibleRows().contains(Integer.valueOf(midRowNumber + 1 + i + 1))
                  && this.theater.getTheaterMap().get(midRowNumber + 1 + i).getEmptySeat()
                  >= groupSize) {
            return midRowNumber + 1 + i + 1;
          } else {
            continue;
          }
        }
        for (int i = 0; i <= (this.theater.getNumOfRow() / 2 - 1); i++) {
          if (this.theater.getAccessibleRows().contains(Integer.valueOf(midRowNumber - i + 1))
              && this.theater.getTheaterMap().get(midRowNumber - i).getEmptySeat() >= groupSize) {
            //return the actual reserved row number as oppose to index of the row.
            return midRowNumber - i + 1;
          } else if (
              this.theater.getAccessibleRows().contains(Integer.valueOf(midRowNumber + 1 + i + 1))
                  && this.theater.getTheaterMap().get(midRowNumber + 1 + i).getEmptySeat()
                  >= groupSize) {
            return midRowNumber + 1 + i + 1;
          } else {
            continue;
          }
        }
      } else {
        midRowNumber = this.theater.getNumOfRow() / 2;
        if (!this.theater.getAccessibleRows().contains(midRowNumber)
            && this.theater.getTheaterMap().get(midRowNumber).getEmptySeat() >= groupSize) {
          //return the actual reserved row number as oppose to index of the row.
          return midRowNumber + 1;
        } else {
          for (int i = 0; i <= this.theater.getNumOfRow() / 2; i++) {
            if (!this.theater.getAccessibleRows().contains(Integer.valueOf(midRowNumber - i + 1))
                && this.theater.getTheaterMap().get(midRowNumber - i).getEmptySeat() >= groupSize) {
              return midRowNumber - i + 1;
            } else if (
                !this.theater.getAccessibleRows().contains(Integer.valueOf(midRowNumber + i + 1))
                    && this.theater.getTheaterMap().get(midRowNumber + i).getEmptySeat()
                    >= groupSize) {
              return midRowNumber + i + 1;
            } else {
              continue;
            }
          }
        }
        if (this.theater.getAccessibleRows().contains(midRowNumber)
            && this.theater.getTheaterMap().get(midRowNumber).getEmptySeat() >= groupSize) {
          //return the actual reserved row number as oppose to index of the row.
          return midRowNumber + 1;
        } else {
          for (int i = 0; i <= this.theater.getNumOfRow() / 2; i++) {
            if (this.theater.getAccessibleRows().contains(Integer.valueOf(midRowNumber - i + 1))
                && this.theater.getTheaterMap().get(midRowNumber - i).getEmptySeat() >= groupSize) {
              return midRowNumber - i + 1;
            } else if (
                this.theater.getAccessibleRows().contains(Integer.valueOf(midRowNumber + i + 1))
                    && this.theater.getTheaterMap().get(midRowNumber + i).getEmptySeat()
                    >= groupSize) {
              return midRowNumber + i + 1;
            } else {
              continue;
            }
          }
        }
      }
      return null;
    }
  }

  /**
   * Reserve seats for the client by name at the found best row.
   *
   * @param clientName the name of the booker client.
   * @param foundRowNum the actual row number as oppose to the index of the row.
   * @param groupSize the group size.
   * @throws Exception the exception.
   */
  public void reserveSeats(String clientName, Integer foundRowNum, Integer groupSize)
      throws Exception {
    Row reservedRow = this.theater.getTheaterMap().get(foundRowNum - 1);
    Integer seatStart = reservedRow.getNumOfSeat() - reservedRow.getEmptySeat();
    for (int i = seatStart; i < seatStart + groupSize; i++) {
      reservedRow.getRowMap().get(i).setReservedFor(clientName);
    }
  }

  /**
   * Show map.
   *
   * @return print the seating map.
   */
  public String showMap() {
    Integer numOfRow = this.theater.getNumOfRow();
    Integer numOfSeat = this.theater.getTheaterMap().get(0).getNumOfSeat();
    StringBuilder map = new StringBuilder();
    for (int i = 0; i < numOfRow; i++) {
      map.append(i + 1);
      for (int j = 0; j < numOfSeat; j++) {
        if (this.theater.getTheaterMap().get(i).getRowMap().get(j).getReservedFor()
            .contentEquals("")) {
          if (this.theater.getAccessibleRows().contains(Integer.valueOf(i + 1))) {
            map.append(" =");
          } else {
            map.append(" _");
          }
        } else {
          map.append(" X");
        }
      }
      map.append("\n");
    }
    return map.toString();
  }
}
