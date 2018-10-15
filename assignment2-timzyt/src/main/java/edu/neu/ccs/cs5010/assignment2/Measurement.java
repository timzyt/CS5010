package edu.neu.ccs.cs5010.assignment2;

import java.util.Objects;

/**
 * The class Measurement.
 *
 * @author timzyt. created on 2018/09/21.
 */
public class Measurement {

  private Fraction value;
  private SystemOfMeasurement som;

  /**
   * Constructs and instantiates a measurement.
   *
   * @param newValue new value for this measurement.
   * @param newSom the system of measurement for this measurement.
   */
  public Measurement(Fraction newValue, SystemOfMeasurement newSom) {
    if (newValue == null || newSom == null) {
      throw new NullValueException("Provided input is null.");
    }
    this.value = newValue;
    this.som = newSom;
  }

  /**
   * print the whole measurement with value and the system of measurement sign.
   *
   * @return String the whole measurement with value and the system of measurement sign.
   */
  public String printMeasurement() {
    String printMrmt;
    if (this.som.equals(SystemOfMeasurement.Metric)) {
      printMrmt = String.format("%smm", this.value.frac2Str());
    } else {
      printMrmt = String.format("%s\"", this.value.frac2Str());
    }
    return printMrmt;
  }

  /**
   * Getter for field 'value'.
   *
   * @return value of this measurement.
   */
  public Fraction getValue() {
    return this.value;
  }

  /**
   * Setter for field 'value'.
   *
   * @param value value for this measurement.
   */
  public void setValue(Fraction value) {
    if (value == null) {
      throw new NullValueException("Provided input is null.");
    }
    this.value = value;
  }

  /**
   * Getter for field 'som'.
   *
   * @return system of measurement for this measurement.
   */
  public SystemOfMeasurement getSom() {
    return this.som;
  }

  /**
   * Setter for field 'som'.
   *
   * @param som system of measurement for this measurement.
   * @throws Exception the exception
   */
  public void setSom(SystemOfMeasurement som) throws Exception {
    if (som == null) {
      throw new NullValueException(
          "Provided input is null.");
    }
    this.som = som;
  }

  /***************************************************************************************
   * equals and hashCode methods.
   * @param obj an object.
   * @return boolean.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Measurement)) {
      return false;
    }
    Measurement that = (Measurement) obj;
    return Objects.equals(getValue(), that.getValue())
        && getSom() == that.getSom();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getValue(), getSom());
  }

  //  public Double metricMeasureToDouble() {
  //    if (this.value == null) {
  //      throw new NullValueException("Provided input is null.");
  //    }
  //    String regex = "\\d{0,9}([.]\\d{0,9}|(\\s\\d{1,9})?[/]\\d{1,9})?";
  //    if (this.value.length() == 0 || !this.value.matches(regex)) {
  //      throw new InvalidConstructorArgumentsException(
  //          "Provided measurement value information is invalid.");
  //    }
  //    if (this.value.contains("/")) {
  //      throw new InvalidSystemOfMeasurementException(
  //      "Provided input is of the wrong system of measurement.");
  //    } else {
  //      return Double.parseDouble(this.value);
  //    }
  //  }

}
