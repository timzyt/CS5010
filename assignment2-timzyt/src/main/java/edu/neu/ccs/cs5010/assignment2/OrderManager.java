package edu.neu.ccs.cs5010.assignment2;

import java.util.HashMap;


/**
 * The class Order manager.
 */
public class OrderManager {

  private HashMap<String, Integer> order = new HashMap<String, Integer>();
  private StockService theStockService;

  /**
   * Getter for field order.
   *
   * @return the order in this order manager.
   */
  public HashMap<String, Integer> getOrder() {
    return this.order;
  }

  /**
   * Setter for field order.
   *
   * @param order an order.
   */
  public void setOrder(HashMap<String, Integer> order) {
    this.order = order;
  }

  /**
   * Setter for field theStockService.
   *
   * @param newStockService a new stock service.
   */
  public void setStockService(StockService newStockService) {
    this.theStockService = newStockService;
  }

  /**
   * take a SKU# as an argument and add that item to the current order if that item is in stock. It
   * should give useful feedback by standard output indicating whether the item was added to the
   * order (a SKU# that is not in stock should not be added, and the user should be informed of the
   * issue).
   *
   * @param newSku the new sku
   */
  public void addToOrder(String newSku) {
    if (newSku == null) {
      throw new NullValueException("Provided SKU# is null.");
    }
    if (newSku.length() == 0) {
      throw new InvalidConstructorArgumentsException("Provided SKU# is invalid.");
    }

    if (theStockService.getStock().containsKey(newSku)) {
      if (this.order.containsKey(newSku) || this.order.get(newSku) != null) {
        Integer newCount = Integer.valueOf(this.order.get(newSku).intValue() + 1);
        this.order.put(newSku, newCount);
      } else {
        this.order.put(newSku, 1);
      }
      System.out.println(
          theStockService.getStock().get(newSku).getCategory() + " SKU# " + newSku
              + " is added to the order.");
    } else {
      System.out.println(
          "Provided item with SKU# " + newSku + " is not in stock, cannot be added to the order.");
    }
  }

  /**
   * take a SKU# as an argument and remove one instance of that item from the current order. It
   * should give useful feedback via standard output as to whether the item was removed.
   *
   * @param newSku the new sku
   */
  public void removeOneFromOrder(String newSku) {
    if (newSku == null) {
      throw new NullValueException("Provided SKU# is null.");
    }
    if (newSku.length() == 0) {
      throw new InvalidConstructorArgumentsException("Provided SKU# is invalid.");
    }
    if (!order.containsKey(newSku)) {
      System.out.println("No item in the order matches provided SKU#.");
    } else {
      Integer newCount = Integer.valueOf(order.get(newSku).intValue() - 1);
      this.order.put(newSku, newCount);
      System.out.println("One item by SKU# " + newSku + " is removed from the order, " + newCount
          + " of such item is left in the order.");
      if (newCount == 0) {
        order.remove(newSku);
      }
    }
  }

  /**
   * confirm that all items in the current order conform to the same measurement system. It should
   * return a Boolean value ("true" if all items conform and "false" if the order includes mixed
   * measurement systems). It should also print a report to the standard output giving useful
   * information about the measurements (it is up to you to decide what this method should report).
   *
   * @return the boolean
   */
  public boolean validateMeasurementSystem() {
    if (this.order == null) {
      throw new NullValueException("Provided order is empty.");
    }
    if (order.isEmpty()) {
      throw new InvalidHashMapKeyException("Provided order is empty.");
    }
    Boolean result = false;
    String[] keyArray = this.order.keySet().toArray(new String[0]);
    String firstMmeasurementSystem = this.theStockService.getStock().get(keyArray[0]).getSom()
        .name();
    for (String nextKey : keyArray) {
      if (!firstMmeasurementSystem
          .contentEquals(theStockService.getStock().get(nextKey).getSom().name())) {
        result = false;
      } else {
        result = true;
      }
    }
    if (result) {
      System.out
          .println("This order contains items only in " + firstMmeasurementSystem + " system.");
    } else {
      System.out.println("This order contains items of mixed measurement system.");
    }
    return result;
  }

  /**
   * take a measurement system (metric or standard) as an argument and delete all items in the order
   * that do not conform to that measurement system, leaving only those items in the order that do
   * conform to the measurement system.
   *
   * @param measurementSystem the measurement system
   */
  public void filterByMeasurementSystem(String measurementSystem) {
    if (this.order == null) {
      throw new NullValueException("Provided order is null.");
    }
    if (measurementSystem == null) {
      throw new NullValueException("Provided measurement system input is null.");
    }
    if (measurementSystem.length() == 0) {
      throw new InvalidConstructorArgumentsException("Provided measurement system is invalid.");
    }
    String[] keyArray = this.order.keySet().toArray(new String[0]);
    for (String nextKey : keyArray) {
      if (!theStockService.getStock().get(nextKey).getSom().name()
          .contentEquals(measurementSystem)) {
        order.remove(nextKey);
      }
    }
  }

  /**
   * check each item in the order for its category (e.g. "Precision Ball Bearings") and return the
   * category if all items  share the same category, and return "Mixed" if the order contains items
   * of different categories.
   *
   * @return the string
   */
  public String orderCategory() {
    if (this.order == null) {
      throw new NullValueException("Provided order is null.");
    }
    if (order.isEmpty()) {
      throw new InvalidHashMapKeyException("Provided order is empty.");
    }
    String[] keyArray = order.keySet().toArray(new String[0]);
    String firstItemCategory = theStockService.getStock().get(keyArray[0]).getCategory();
    for (String nextKey : keyArray) {
      if (!firstItemCategory
          .contentEquals(theStockService.getStock().get(nextKey).getCategory())) {
        return "Mixed";
      }
    }
    return firstItemCategory;
  }

  /**
   * print out (to standard output) a tabulated report of the current order listing the category,
   * SKU#, and price of each item in the order, with the total cost at the bottom of the report.
   */
  public void printDocket() {
    Integer totalPriceInCent = 0;
    if (this.order == null) {
      throw new NullValueException("Provided order is null.");
    }
    if (order.isEmpty()) {
      throw new InvalidHashMapKeyException("Provided order is empty.");
    }
    String[] keyArray = order.keySet().toArray(new String[0]);
    for (String nextKey : keyArray) {
      System.out.println(
          theStockService.getStock().get(nextKey).getCategory() + " " + nextKey + " "
              + theStockService.getStock().get(nextKey).getPrice().printPrice());
      totalPriceInCent += theStockService.getStock().get(nextKey).getPrice().getPriceInCent();
    }
    StringBuffer strbdr = new StringBuffer()
        .append(theStockService.getStock().get(keyArray[0]).getPrice().getCurrency())
        .append(((double) totalPriceInCent / 100.00));
    System.out.print(strbdr.toString());
  }

  /**
   * take two arbitrary stock item SKU#s and determine whether they represent a shaft/shaft-mounted
   * pair of items for which the diameter of the shaft matches the "for shaft diameter" value of the
   * shaft-mounted part. It should return a Boolean value representing whether the two items fit
   * each other. If so, it should print a report to standard output following the given format.
   *
   * @param sku1 the sku 1
   * @param sku2 the sku 2
   * @return the boolean
   */
  public boolean checkFit(String sku1, String sku2) {
    String category1;
    String category2;
    SystemOfMeasurement som1;
    SystemOfMeasurement som2;
    if (sku1 == null || sku2 == null) {
      throw new NullValueException("Provided SKU# is null.");
    }
    if (sku1.length() == 0 || sku2.length() == 0) {
      throw new InvalidConstructorArgumentsException("Provided SKU# is invalid.");
    }
    if (!theStockService.getStock().containsKey(sku1) && !theStockService.getStock()
        .containsKey(sku2)) {
      StringBuilder errorMsg3 = new StringBuilder();
      errorMsg3.append("No item in the stock matches provided SKU# ").append(sku1).append(" and ")
          .append(sku2).append(".");
      System.out.println(errorMsg3.toString());
    } else if (!theStockService.getStock().containsKey(sku1)) {
      StringBuilder errorMsg1 = new StringBuilder();
      errorMsg1.append("No item in the stock matches provided SKU# ").append(sku1).append(".");
      System.out.println(errorMsg1.toString());
    } else if (!theStockService.getStock().containsKey(sku2)) {
      StringBuilder errorMsg2 = new StringBuilder();
      errorMsg2.append("No item in the stock matches provided SKU# ").append(sku2).append(".");
      System.out.println(errorMsg2.toString());
    } else {
      category1 = theStockService.getStock().get(sku1).getCategory();
      category2 = theStockService.getStock().get(sku2).getCategory();
      som1 = theStockService.getStock().get(sku1).getSom();
      som2 = theStockService.getStock().get(sku2).getSom();
      if ((!category1.contains("Rotary Shaft") && !category2
          .contains("Rotary Shaft")) || (
          category1.contains("Rotary Shaft") && category2.contains("Rotary Shaft"))) {
        System.out.println("Not a shaft/shaft-mounted pair.");
      } else if (!som1.equals(som2)) {
        System.out.println("System of Measurement don't match.");
      } else if (category1.contains("Rotary Shaft")) {
        if (theStockService.getStock().get(sku1).getShaft()
            .equals(theStockService.getStock().get(sku2).getShaft())) {
          StringBuilder resMsg1 = new StringBuilder();
          resMsg1.append(theStockService.getStock().get(sku2).getCategory()).append(" SKU# ")
              .append(sku2).append(" for ")
              .append(theStockService.getStock().get(sku2).getShaft().printMeasurement())
              .append(" shaft fits on Rotary Shafts SKU# ").append(sku1);
          System.out.println(resMsg1.toString());
          return true;
        } else {
          StringBuilder resMsg2 = new StringBuilder();
          resMsg2.append(theStockService.getStock().get(sku2).getCategory()).append(" SKU# ")
              .append(sku2).append(" for ")
              .append(theStockService.getStock().get(sku2).getShaft().printMeasurement())
              .append(" shaft does not fit on Rotary Shafts SKU# ").append(sku1);
          System.out.println(resMsg2);
          return false;
        }
      }
    }
    return false;
  }

}
