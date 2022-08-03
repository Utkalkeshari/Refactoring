import java.time.Month;
import java.util.List;

public class BankStatementProcessor {
	private List<BankTransaction> transactions;

	public BankStatementProcessor(List<BankTransaction> transactions) {
		super();
		this.transactions = transactions;
	}

	public double calculateTotalAmmount() {
		double totalAmmount = 0;
		for(BankTransaction bankTransaction:transactions) {
			totalAmmount = totalAmmount + bankTransaction.getAmmount();
		}
		return totalAmmount;
	}
	public  double SelectInMonth( Month month) {
		double total =0;
		for(BankTransaction bankTransaction:transactions) {
			if(bankTransaction.getDate().getMonth() == month) {
				total = total+bankTransaction.getAmmount();
			}
		}
		return total;
	}
	public double calculateTotalForCategory(String category) {
		double total =0;
		for(BankTransaction bankTransaction:transactions) {
			if(bankTransaction.getDescription().equals(category)) {
				total = total+bankTransaction.getAmmount();
			}
		}
		return total;
	}

}
