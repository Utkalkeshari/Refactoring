import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyser {
	private  static final String resource = "C:\\Users\\user\\Desktop\\Real World Software Developement\\Real-World-Software-Development\\src\\test\\resources\\";
	private static final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
	public static void main(final String... args) throws IOException {
		// TODO Auto-generated method stub
		final Path path = Paths.get(resource+args[0]);
		final List<String> linesFromCsvFile= Files.readAllLines(path);
		List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(linesFromCsvFile);
		BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
		CollectSummary(bankStatementProcessor);
	}

	private static void CollectSummary(BankStatementProcessor bankStatementProcessor) {
		// TODO Auto-generated method stub
		System.out.println("Total Ammount"+bankStatementProcessor.calculateTotalAmmount());
		System.out.println("Total Ammount for January"+bankStatementProcessor.SelectInMonth(Month.JANUARY));
		System.out.println("Total Ammount for Tesco Category"+bankStatementProcessor.calculateTotalForCategory("Tesco"));
	}

	

}
