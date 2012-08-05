package hm.moe.heignamerican.GraphSample.util;

import java.io.Closeable;
import java.io.IOException;

public class Util {
	public static double norm3(final double aX, final double aY, final double aZ) {
		return Math.sqrt(aX * aX + aY * aY + aZ * aZ);
	}

	public static double normN(final double... aValues) {
		double sum = 0;
		for (final double tValue : aValues) {
			sum += tValue * tValue;
		}
		return Math.sqrt(sum);
	}

	public static void closeQuietly(final Closeable aCloseable) {
		try {
			aCloseable.close();
		} catch (IOException aCause) {
			aCause.printStackTrace();
		}
	}
}
