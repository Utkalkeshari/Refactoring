import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankStatementAnalyser {
	private  static final String resource = "C:\\Users\\user\\Desktop\\Real World Software Developement\\Real-World-Software-Development\\src\\test\\resources\\";

	public static void main(final String... args) throws IOException {
		// TODO Auto-generated method stub
		final Path path = Paths.get(resource+args[0]);
		final List<String> linesFromCsvFile= Files.readAllLines(path);
		double total =0d;
		for(final String line:linesFromCsvFile) {
			final String[] column = line.split(",");
			total = total+ Double.parseDouble(column[1]);
		}
			System.out.println("The total for All transaction"+total);
	}

}
