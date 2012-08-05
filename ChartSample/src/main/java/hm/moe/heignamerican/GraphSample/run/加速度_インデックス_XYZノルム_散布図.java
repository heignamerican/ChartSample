package hm.moe.heignamerican.GraphSample.run;

import hm.moe.heignamerican.GraphSample.CreateMyChart;
import hm.moe.heignamerican.GraphSample.util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.CategoryTableXYDataset;

public class 加速度_インデックス_XYZノルム_散布図 extends CreateMyChart {
	public static void main(final String[] args) throws IOException {
		new 加速度_インデックス_XYZノルム_散布図().execute();
	}

	@Override
	protected JFreeChart createJFreeChartFrom(final Reader aReader) throws IOException {
		final CategoryTableXYDataset tDataset = new CategoryTableXYDataset();

		try (BufferedReader tBufferedReader = new BufferedReader(aReader)) {
			int tIndex = 1;
			String tLine = null;
			while ((tLine = tBufferedReader.readLine()) != null) {
				final String[] tSplit = tLine.split(",");
				final double tAccelerationX = Double.parseDouble(tSplit[1]);
				final double tAccelerationY = Double.parseDouble(tSplit[2]);
				final double tAccelerationZ = Double.parseDouble(tSplit[3]);
				final double tAccelerationNorm = Util.norm3(tAccelerationX, tAccelerationY, tAccelerationZ);
				tDataset.add(tIndex, tAccelerationX, "AccelerationX");
				tDataset.add(tIndex, tAccelerationY, "AccelerationY");
				tDataset.add(tIndex, tAccelerationZ, "AccelerationZ");
				tDataset.add(tIndex, tAccelerationNorm, "AccelerationNorm");
				tIndex++;
			}
		}

		return ChartFactory.createScatterPlot("タイトル", "インデックス", "加速度とか。", tDataset, PlotOrientation.VERTICAL, true, false, false);
	}
}
