package edu.neu.ccs.cs5010.assignment6.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentNavigableMap;

public class CallableProcess implements Callable<ConcurrentNavigableMap<Long, ArrayList<Long>>> {

  private List<String> lines;

  CallableProcess(List<String> lines) {
    this.lines = lines;
  }

  @Override
  public ConcurrentNavigableMap<Long, ArrayList<Long>> call() throws Exception {
    ConcurrentMapBuilder conMapBuilder = new ConcurrentMapBuilder();
    conMapBuilder.buildMap(this.lines);
    ConcurrentNavigableMap<Long, ArrayList<Long>> conMap = conMapBuilder.getDataMap();
    return conMap;
  }
}