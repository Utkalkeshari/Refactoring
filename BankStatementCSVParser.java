import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class BankStatementCSVParser {
	
	private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
	
	public BankTransaction parseFromCSV(String line) {
		String[] column= line.split(",");
		LocalDate date = LocalDate.parse(column[0], dateFormat);
		Double ammount = Double.parseDouble(column[1]);
		String description = column[2];
		return new BankTransaction(date, ammount, description);
	}
	
	public List<BankTransaction> parseLinesFromCSV(List<String> lines){
		List<BankTransaction> bankTransactions = new LinkedList();
		for(String line:lines) {
			bankTransactions.add(parseFromCSV(line));
		}
		return bankTransactions;
	}

}
