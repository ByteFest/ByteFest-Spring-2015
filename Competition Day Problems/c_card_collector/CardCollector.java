import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class CardCollector {
	public static void main(String args[]) {
		CardCollector cc = new CardCollector();
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(new File("c.in")));
			String line = buffer.readLine();
			while (line != null) {

				int N = Integer.parseInt(line.substring(0, line.indexOf(",")));
				String[] items = line.substring(line.indexOf(",") + 1)
						.replaceAll("\\{", "").replaceAll("\\}", "").split(",");
				int[] cardPrices = new int[items.length];
				for (int count = 0; count < items.length; count++) {
					cardPrices[count] = Integer.parseInt(items[count].trim());
				}
				System.out.println(cc.minimum(N, cardPrices));
				line = buffer.readLine();
			}
			buffer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int minimum(int N, int[] cardPrices) {
		Arrays.sort(cardPrices);
		int total = 0;
		for (int i = 0; i < N; i++) {
			total += cardPrices[i];
		}
		return total;
	}

}