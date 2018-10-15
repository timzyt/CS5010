package edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle;

/**
 * The enum class Crash.
 */
public enum CrashTypes {
  /**
   * Fender bender crash types.
   */
  Fender_bender,
  /**
   * Crash without bodily injuries crash types.
   */
  Crash_without_bodily_injuries,
  /**
   * Crash involving bodily injuries crash types.
   */
  Crash_involing_bodily_injuries;

  /**
   * print the enum values to string.
   *
   * @return string.
   */
  public String toString() {
    StringBuilder strBuilder = new StringBuilder();
    switch (this) {
      case Fender_bender:
        strBuilder.append("Fender bender");
        break;
      case Crash_without_bodily_injuries:
        strBuilder.append("Crash without bodily injuries");
        break;
      case Crash_involing_bodily_injuries:
        strBuilder.append("Crash involving bodily injuries");
        break;
      default:
        break;
    }
    return strBuilder.toString();
  }
}
