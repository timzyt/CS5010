package edu.neu.ccs.cs5010.assignment7.javautil;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class PlotterUtil {

  /**
   * the index of latency count in the arrayList.
   */
  public static final Integer INDEX_OF_COUNT = 0;

  private JFreeChart chart;

  /**
   * Generate throughput plot.
   * @param chartName chart name
   * @param throughputData throughput data
   * @param title title of the plot
   * @param titleX x axis title
   * @param titleY y axis
   * @throws IOException throws IOException when necessary.
   */
  public void plotThroughput(String chartName, Map<Long, ArrayList<Long>> throughputData,
      String title, String titleX, String titleY) throws IOException {
    XYDataset dataset = createDatasetThroughput(chartName, throughputData);
    chart = createChart(dataset, title, titleX, titleY);
    String fileName = chartName + ".png";
    ChartUtilities.saveChartAsPNG(new File(fileName), chart, 1000, 800);
  }

  /**
   * Generate latency plot.
   * @param chartName chart name
   * @param latencyData throughput data
   * @param title title of the plot
   * @param titleX x axis title
   * @param titleY y axis
   * @throws IOException throws IOException when necessary.
   */
  public void plotLatency(String chartName, Map<Long, Integer> latencyData, String title,
      String titleX, String titleY) throws IOException {
    XYDataset dataset = createDatasetLatency(chartName, latencyData);
    chart = createChart(dataset, title, titleX, titleY);
    String fileName = chartName + ".png";
    ChartUtilities.saveChartAsPNG(new File(fileName), chart, 1000, 800);
  }

  /**
   * create throughput dataset.
   * @param chartName chart name.
   * @param throughputData throughput data.
   * @return XYDataset.
   */
  private XYDataset createDatasetThroughput(String chartName,
      Map<Long, ArrayList<Long>> throughputData) {

    XYSeries series = new XYSeries(chartName);
    Iterator<Entry<Long, ArrayList<Long>>> setIt = throughputData.entrySet().iterator();
    Long baseTime = setIt.next().getKey();
    while (setIt.hasNext()) {
      Map.Entry<Long, ArrayList<Long>> pair = setIt.next();
      Long key = pair.getKey() - baseTime;
      ArrayList<Long> value = pair.getValue();
      series.add(key, value.get(INDEX_OF_COUNT));
    }
    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(series);

    return dataset;
  }

  /**
   * create latency dataset.
   * @param chartName chart name.
   * @param latencyData latency data.
   * @return XYDataset.
   */
  private XYDataset createDatasetLatency(String chartName, Map<Long, Integer> latencyData) {

    XYSeries series = new XYSeries(chartName);
    Iterator<Entry<Long, Integer>> setIt = latencyData.entrySet().iterator();
    while (setIt.hasNext()) {
      Map.Entry<Long, Integer> pair = setIt.next();
      Long key = pair.getKey();
      Integer value = pair.getValue();
      series.add(key, value);
    }
    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(series);

    return dataset;
  }

  /**
   * Create jFree chart.
   * @param dataset XYDataset
   * @param title the title of the chart
   * @param labelX the label of x axis
   * @param labelY the label of y axis
   * @return JFreeChart
   */
  private JFreeChart createChart(XYDataset dataset, String title, String labelX,
      String labelY) {
    JFreeChart chart = ChartFactory.createXYLineChart(
        title,
        labelX,
        labelY,
        dataset,
        PlotOrientation.VERTICAL,
        true,
        true,
        false
    );

    XYPlot plot = chart.getXYPlot();

    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
    renderer.setSeriesPaint(0, Color.RED);
    renderer.setSeriesStroke(0, new BasicStroke(2.0f));

    plot.setRenderer(renderer);
    plot.setBackgroundPaint(Color.white);

    plot.setRangeGridlinesVisible(true);
    plot.setRangeGridlinePaint(Color.BLACK);

    plot.setDomainGridlinesVisible(true);
    plot.setDomainGridlinePaint(Color.BLACK);

    chart.getLegend().setFrame(BlockBorder.NONE);

    chart.setTitle(new TextTitle(title,
            new Font("Serif", Font.BOLD, 18)
        )
    );

    return chart;

  }
}