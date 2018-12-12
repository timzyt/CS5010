package edu.neu.ccs.cs5010.assignment6.concurrent;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * The multiTread process class.
 */
public class ConcurrentProcess {

  public static final Integer MAX_THREAD = 30;
  public static final Integer LINES_IN_BATCH = 3000;

  public static final Integer ZERO = 0;
  private int counter = 1;

  private String inputFileName;

  public ConcurrentProcess(String inputFileName) {
    this.inputFileName = inputFileName;
  }

  /**
   * Read and process the file using multiTread.
   * @return the ConcurrentOutputObject corpus.
   * @throws IOException throws IOException when necessary.
   * @throws ExecutionException throws ExecutionException when necessary.
   * @throws InterruptedException throws InterruptedException when necessary.
   */
  public ConcurrentOutputObject multiThreadProcess()
      throws IOException, ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREAD);
    List<Future> futures = new ArrayList<>();
    try {
      BufferedReader bufferedReader = new BufferedReader(
          new InputStreamReader(new FileInputStream(inputFileName), "UTF-8"));
      String line;
      List<String> lines = new ArrayList<>();
      int lineCount = ZERO;

      while ((line = bufferedReader.readLine()) != null) {
        // use comma as separator
        // create object, add to list.
        // if reaches limit, submit the job.
        lineCount++;
        if (lineCount % LINES_IN_BATCH != ZERO) {
          lines.add(line);
        } else {
          if (lines.size() != ZERO) {
            Future<ConcurrentNavigableMap<Long, ArrayList<Long>>> result = executorService
                .submit(new CallableProcess(counter, lines));
            futures.add(result);
          }
          lines = new ArrayList<>();
          lines.add(line);
          counter++;
        }
      }
      if (lines.size() != ZERO) {
        Future<ConcurrentNavigableMap<Long, ArrayList<Long>>> result = executorService
            .submit(new CallableProcess(counter, lines));
        futures.add(result);
      }
      bufferedReader.close();
      executorService.shutdown();
      try {
        if (!executorService.awaitTermination(60, TimeUnit.MILLISECONDS)) {
          executorService.shutdownNow();
        }
      } catch (InterruptedException ex) {
        executorService.shutdownNow();
        Thread.currentThread().interrupt();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    //Combine the result.
    ConcurrentOutputObject corpus = new ConcurrentOutputObject();

    for (Future<ConcurrentNavigableMap<Long, ArrayList<Long>>> f : futures) {
      // Aggregate
      ConcurrentNavigableMap<Long, ArrayList<Long>> map = f.get();
      System.out.println("!!!Adding map of size " + map.size());
      corpus.add(map);
      System.out.println("!!!corpus size is " + corpus.getConcurrentMap().size());
    }

    return corpus;
  }
}