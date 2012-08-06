package hm.moe.heignamerican.GraphSample.run;

import hm.moe.heignamerican.GraphSample.CreateMyChart;
import hm.moe.heignamerican.GraphSample.util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class 加速度_インデックス_ノルム_折れ線 extends CreateMyChart {
	public static void main(final String[] args) throws IOException {
		new 加速度_インデックス_ノルム_折れ線().execute();
	}

	@Override
	protected JFreeChart createJFreeChartFrom(final Reader aReader) throws IOException {
		final DefaultCategoryDataset tDataset = new DefaultCategoryDataset();

		try (BufferedReader tBufferedReader = new BufferedReader(aReader)) {
			int tIndex = 1;
			String tLine = null;
			while ((tLine = tBufferedReader.readLine()) != null) {
				final String[] tSplit = tLine.split(",");
				final double tAccelerationNorm = Util.norm3(Double.parseDouble(tSplit[1]), Double.parseDouble(tSplit[2]), Double.parseDouble(tSplit[3]));
				final String tIndexString = String.valueOf(tIndex);
				tDataset.addValue(tAccelerationNorm, "AccelerationNorm", tIndexString);
				tIndex++;
			}
		}

		return ChartFactory.createLineChart("タイトル", "インデックス", "加速度", tDataset, PlotOrientation.VERTICAL, true, false, false);
	}
}
