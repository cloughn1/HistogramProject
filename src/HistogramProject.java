import java.io.*;

public class HistogramProject {
	public static void main(String[] args) {
		File dataFile = new File("src/data.txt");

		try {
			FileReader fileReader = new FileReader(dataFile.getAbsoluteFile());
			BufferedReader reader = new BufferedReader(fileReader);

		} catch(FileNotFoundException e){
			System.out.println("Data file not found");
		}
	}
}
