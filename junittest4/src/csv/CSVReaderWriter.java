package csv;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CSVReaderWriter {

//	public static void main(String[] args) {
//		String filePath = "./src/csv/testParam.csv";
//		System.out.println("starting read user.csv file");
//		readCSV(filePath);
//	}

	public static List<Integer[]> readCSV(String filePath) {
		// TODO Auto-generated method stub
		BufferedReader reader = null;
		String line = "";
		
		List<Integer[]> data = new ArrayList<>();
		
		try {
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();

			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				String[] fields = line.split(",");
				
				Integer[] rowdata = {Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), Integer.parseInt(fields[2])};
				data.add(rowdata);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return data;
	}
}
