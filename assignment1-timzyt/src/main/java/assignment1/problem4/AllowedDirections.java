package assignment1.problem4;

import java.util.HashMap;
import java.util.Map;

public class AllowedDirections {

  private Map<Direction, Direction> allowedDirectionChanges = new HashMap<Direction, Direction>() {
    {
      put(Direction.north, Direction.south);
      put(Direction.south, Direction.north);
      put(Direction.east, Direction.west);
      put(Direction.west, Direction.east);
    }
  };

  public HashMap<Direction, Direction> getAllowedDirectionChanges() {
    return (HashMap<Direction, Direction>) allowedDirectionChanges;
  }
}
