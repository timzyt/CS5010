package edu.neu.ccs.cs5010.assignment7.concurrent;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class FileSplit {

  /**
   * Split file by number assigned.
   *
   * @param fileName the file name
   * @param count the count for number of partitions
   * @return list of string as file partitions
   * @throws IOException the IO exception
   * @throws InterruptedException the interrupted exception
   */
  public List<String> splitByCount(String fileName, int count)
      throws IOException, InterruptedException {

    List<String> parts = new ArrayList<String>();
    File file = new File(fileName);
    int blockSize = (int) Math.ceil(file.length() / (double) count);
    RandomAccessFile raf = new RandomAccessFile(fileName, "r");
    long totalLen = raf.length();
    CountDownLatch latch = new CountDownLatch(count);

    long startPos = 0L;
    long nextPos = 0L;

    for (int i = 0; i < count; i++) {
      nextPos = Long.min((long) (i + 1) * blockSize, totalLen - 1);
      raf.seek(nextPos);
      //Calculate the start position for the next file.
      do {
        raf.seek(nextPos);
        if (raf.readByte() == '\n') {
          nextPos = nextPos + 1;
          break;
        }
        nextPos--;
      } while (true);
      long readSizeTemp = nextPos - startPos;
      int readSize = (int) readSizeTemp;
      String partFileName = fileName.replace("raw", "raw" + (i + 1));
      new SplitRunnable(readSize, startPos, partFileName, file, latch).run();
      startPos = nextPos;
      parts.add(partFileName);
    }
    //Wait until all the files are written.
    latch.await();
    return parts;
  }
}
