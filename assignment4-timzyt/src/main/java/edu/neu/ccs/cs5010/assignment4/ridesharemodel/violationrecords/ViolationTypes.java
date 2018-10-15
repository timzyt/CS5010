package edu.neu.ccs.cs5010.assignment4.ridesharemodel.violationrecords;

/**
 * The enum class violation types.
 */
public enum ViolationTypes {
  /**
   * Distracted driving violation types.
   */
  Distracted_driving,
  /**
   * Reckless driving violation types.
   */
  Reckless_driving,
  /**
   * Speeding violation types.
   */
  Speeding,
  /**
   * Driving under influence violation types.
   */
  Driving_under_influence,
  /**
   * Failure to respect traffic signs violation types.
   */
  Failure_to_respect_traffic_signs,
  /**
   * Driving without a valid license and or insurance violation types.
   */
  Driving_without_a_valid_license_and_or_insurance,
  /**
   * Parking violation violation types.
   */
  Parking_violation,
  /**
   * Paperwork issues violation types.
   */
  Paperwork_issues,
  /**
   * Problems with the vehicle violation types.
   */
  Problems_with_the_vehicle;

  /**
   * print the enum values to string.
   *
   * @return string.
   */
  public String toString() {
    StringBuilder strBuilder = new StringBuilder();
    switch (this) {
      case Distracted_driving:
        strBuilder.append("Distracted driving");
        break;
      case Reckless_driving:
        strBuilder.append("Reckless driving");
        break;
      case Speeding:
        strBuilder.append("Speeding");
        break;
      case Driving_under_influence:
        strBuilder.append("Driving under influence");
        break;
      case Failure_to_respect_traffic_signs:
        strBuilder.append("Failure to respect traffic signs");
        break;
      case Driving_without_a_valid_license_and_or_insurance:
        strBuilder.append("Driving without a valid license and or instance");
        break;
      case Parking_violation:
        strBuilder.append("Parking violation");
        break;
      case Paperwork_issues:
        strBuilder.append("Paperwork issues");
        break;
      case Problems_with_the_vehicle:
        strBuilder.append("Problems with the vehicle");
        break;
      default:
        break;
    }
    return strBuilder.toString();
  }
}
