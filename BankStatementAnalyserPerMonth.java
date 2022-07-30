import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankStatementAnalyserPerMonth {
	private  static final String resource = "C:\\Users\\user\\Desktop\\Real World Software Developement\\Real-World-Software-Development\\src\\test\\resources\\";
	public static void main(final String... args) throws IOException {
		// TODO Auto-generated method stub
		final Path path = Paths.get(resource+args[0]);
		final List<String> linesFromCsvFile= Files.readAllLines(path);
		double total =0d;
		DateTimeFormatter date_pattern= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for(String line:linesFromCsvFile) {
			String[] column = line.split(",");
			
			LocalDate date =LocalDate.parse(column[0],date_pattern);
			if(date.getMonth() == Month.JANUARY) {
				total = total+Double.parseDouble(column[1]);
			;}
		}
		System.out.println("Total spending for January=="+total);
	}

}
