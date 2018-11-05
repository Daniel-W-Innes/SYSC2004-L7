import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lab7a {

	public static void main(String[] args) throws IOException {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String line = "";
		ArrayList<Row> Rows = new ArrayList<Row>();
		String[] columnHeadings = null;
		try {
			fileReader = new FileReader("sampleCSV.csv");
			bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				columnHeadings = line.split(",");
				Rows.add(new Row(columnHeadings.length));
				for (int i = 0; i < columnHeadings.length; ++i) {
					Rows.get(Rows.size() - 1).add(i, columnHeadings[i]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			fileReader.close();
			for (int i = 0; i < Rows.size(); ++i) {
				System.out.println(Rows.get(i).toSring());
			}
		}
	}

}

class Row {
	private String[] columns;

	Row(int numColumns) {
		columns = new String[numColumns];
	}

	public void add(int column, String value) {
		columns[column] = value;
	}

	public String toSring() {
		String string = "";
		for (int i = 0; i < columns.length; ++i) {
			string += columns[i] + ", ";
		}
		return string;
	}
}