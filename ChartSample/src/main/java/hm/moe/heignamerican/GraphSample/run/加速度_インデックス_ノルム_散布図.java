package hm.moe.heignamerican.GraphSample.run;

import hm.moe.heignamerican.GraphSample.CreateMyChart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

public class 加速度_インデックス_ノルム_散布図 extends CreateMyChart {
	public static void main(final String[] args) throws IOException {
		new 加速度_インデックス_ノルム_散布図().execute();
	}

	@Override
	protected JFreeChart createJFreeChartFrom(final Reader aIn) throws IOException {
		final DefaultTableXYDataset tDataset = new DefaultTableXYDataset();
		final XYSeries tAccelerationX = new XYSeries("AccelerationX", false, false);
		tDataset.addSeries(tAccelerationX);

		try (BufferedReader tBufferedReader = new BufferedReader(aIn)) {
			int tIndex = 1;
			String tLine = null;
			while ((tLine = tBufferedReader.readLine()) != null) {
				final String[] tSplit = tLine.split(",");
				tAccelerationX.add(tIndex, Double.parseDouble(tSplit[1]));
				tIndex++;
			}
		}

		return ChartFactory.createScatterPlot("タイトル", "インデックス", "いろいろ。", tDataset, PlotOrientation.VERTICAL, true, false, false);
	}
}
