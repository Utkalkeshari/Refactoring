import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyser {
	private  static final String resource = "C:\\Users\\user\\Desktop\\Real World Software Developement\\Real-World-Software-Development\\src\\test\\resources\\";

	public static void main(final String... args) throws IOException {
		// TODO Auto-generated method stub
		final Path path = Paths.get(resource+args[0]);
		final List<String> linesFromCsvFile= Files.readAllLines(path);
		BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
		List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(linesFromCsvFile);
		System.out.println("Total Transaction ammount is "+calculateTotalAmmount(bankTransactions));
		System.out.println("Transaction in January "+ SelectInMonth(bankTransactions,Month.JANUARY));
	}

	private static double SelectInMonth(List<BankTransaction> bankTransactions, Month month) {
		double total =0;
		for(BankTransaction bankTransaction:bankTransactions) {
			if(bankTransaction.getDate().getMonth() == month) {
				total = total+bankTransaction.getAmmount();
			}
		}
		return total;
	}

	private static double calculateTotalAmmount(List<BankTransaction> bankTransactions) {
		double totalAmmount = 0;
		for(BankTransaction bankTransaction:bankTransactions) {
			totalAmmount = totalAmmount + bankTransaction.getAmmount();
		}
		return totalAmmount;
	}

}
