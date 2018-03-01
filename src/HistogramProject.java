import java.io.*;

public class HistogramProject {
	public static void main(String[] args) {
		File dataFile = new File("src/data.txt");

		try {
			FileReader fileReader = new FileReader(dataFile.getAbsoluteFile());
			BufferedReader reader = new BufferedReader(fileReader);
			String nextLine = reader.readLine();
			Histogram histogram = new Histogram(0, 9);

			while(nextLine != null){
				char firstChar = nextLine.charAt(0);
				int firstDigit = Character.getNumericValue(firstChar);
				histogram.submit(firstDigit);
				nextLine = reader.readLine();
			}

			System.out.println(histogram);

		} catch(FileNotFoundException e){
			System.out.println("Data file not found");
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}
