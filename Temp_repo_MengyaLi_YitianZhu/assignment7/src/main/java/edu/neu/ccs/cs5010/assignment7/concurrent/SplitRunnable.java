package edu.neu.ccs.cs5010.assignment7.concurrent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.concurrent.CountDownLatch;

public class SplitRunnable implements Runnable {

  /**
   * The Byte size.
   */
  int byteSize;
  /**
   * The Part file name.
   */
  String partFileName;
  /**
   * The Origin file.
   */
  File originFile;
  /**
   * The Start pos.
   */
  long startPos;
  /**
   * The Latch.
   */
  CountDownLatch latch;

  /**
   * Instantiates a new Split runnable.
   *
   * @param byteSize the byte size
   * @param startPos the start pos
   * @param partFileName the part file name
   * @param originFile the origin file
   * @param latch the latch
   */
  public SplitRunnable(int byteSize, long startPos, String partFileName,
      File originFile, CountDownLatch latch) {
    this.startPos = startPos;
    this.byteSize = byteSize;
    this.partFileName = partFileName;
    this.originFile = originFile;
    this.latch = latch;
  }

  /**
   * Override method.
   */
  public void run() {

    RandomAccessFile randomAccessFile;
    OutputStream outputStream = null;

    try {
      randomAccessFile = new RandomAccessFile(originFile, "r");
      byte[] bytes = new byte[byteSize];
      randomAccessFile.seek(startPos);// Move to the start of the segment
      int length = randomAccessFile.read(bytes);
      outputStream = new FileOutputStream(partFileName);
      outputStream.write(bytes, 0, length);
      outputStream.flush();
      outputStream.close();
      latch.countDown();
    } catch (IOException e) {
      e.printStackTrace();
      latch.countDown();
    } finally {
      if (outputStream != null) {
        try {
          outputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
