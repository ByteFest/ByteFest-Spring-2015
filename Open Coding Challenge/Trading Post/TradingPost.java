import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TradingPost {
	private static final long INF = Long.MAX_VALUE / 2;
	private static final int MAX = 1000000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TradingPost tp = new TradingPost();
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(new File("trading_post.in")));
			String line = buffer.readLine(); // Ignore first line. I don't care
												// about how many tests.
			line = buffer.readLine();
			while (line != null) {
				String[] items = line.split(",");
				int[] outputValues = new int[items.length];
				for (int count = 0; count < items.length; count++) {
					outputValues[count] = Integer.parseInt(items[count].trim());
				}
				line= buffer.readLine();
				int startingValue = Integer.parseInt(line);
				System.out.println(tp.howManyTrades(outputValues, startingValue));
				line = buffer.readLine();
			}
			buffer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public long howManyTrades(int[] outputValues, long inputValue) {

		int n = outputValues.length;

		long[] d = new long[MAX + 1];
		long[] f = new long[MAX + 1];
		long[] q = new long[MAX + 1];
		long[] w = new long[MAX + 1];
		q[1] = 1;
		w[1] = 1;

		for (int i = 2; i <= MAX; i++) {
			q[i] = INF;
			w[i] = INF;
			for (int j = n - 1; j >= 0; j--) {
				if (outputValues[j] < i) {
					int ii = i - outputValues[j];
					if (w[ii] + 1 < q[i]) {
						q[i] = w[ii] + 1;
						d[i] = f[ii] + d[outputValues[j]] + 1;
					}
				}
			}
			for (int j = n - 1; j >= 0; j--) {
				if (outputValues[j] <= i) {
					int ii = i - outputValues[j];
					if (w[ii] + 1 < w[i]) {
						w[i] = w[ii] + 1;
						f[i] = f[ii] + d[outputValues[j]];
					}
				}
			}
			// System.out.println("" + i + " " + q[i] + " " + w[i] + " " + d[i]
			// + " " + f[i] + " ");
		}

		if (inputValue <= MAX)
			return d[((int) inputValue)];

		long min = INF;
		long res = 0;

		long k = inputValue / outputValues[n - 1];
		while (inputValue - k * outputValues[n - 1] <= MAX) {
			long r = inputValue - outputValues[n - 1] * k;
			long m = w[((int) r)] + k;
			if (m < min) {
				min = m;
				res = f[((int) r)] + d[outputValues[n - 1]] * k + 1;
			}
			k--;
		}

		return res;
	}

}
