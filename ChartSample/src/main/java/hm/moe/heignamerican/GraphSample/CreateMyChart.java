package hm.moe.heignamerican.GraphSample;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;

public abstract class CreateMyChart {
	protected void execute() throws IOException {
		final Class<?> tClazz = this.getClass();

		ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());

		final JFreeChart tJFreeChart;
		try (final FileReader tReader = new FileReader("input/acceleration.log")) {
			tJFreeChart = createJFreeChartFrom(tReader);
		}

		try (final FileOutputStream tFileOutputStream = new FileOutputStream("output/" + tClazz.getSimpleName() + ".png")) {
			ChartUtilities.writeChartAsPNG(tFileOutputStream, tJFreeChart, 800, 800);
		}
	}

	protected abstract JFreeChart createJFreeChartFrom(final Reader aIn) throws IOException;
}
