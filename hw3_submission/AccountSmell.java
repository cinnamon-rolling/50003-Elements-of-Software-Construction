import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class Transaction {
	private String type;
	private int amount;
	
	public Transaction (String newType, int newAmount) {
		this.type = newType;
		this.amount = newAmount;
	}
}


public class AccountSmell {
  private int balance = 0;
  private List<Transaction> ListOfAllTransactions = new ArrayList<Transaction>();
  private String lastDebitTime;
  private String lastCreditTime;
  
  public AccountSmell () {
  }

  public AccountSmell (int balance) {
    this.balance = balance;
  }
  
  public void deposite (int amount) {
    balance += amount;
  }
    
  public void setBalance (int amount) {
    balance = amount;
  }
  
  public int getBalance () {
    return balance;
  }
  
  public void addTransaction(String type, int amount){
    //add to the transaction list
    ListOfAllTransactions.add(new Transaction(type, amount));

  }

  public String updateTransactionTime(){
    //update the last debit date
    Calendar cal = Calendar.getInstance();
    
    String time = cal.get(Calendar.DATE) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR);  

    return time;
  }
  

  // this method has a long method smell
  public void CrebitTransaction(int amount) {
	  //reduce the amount
	  deposite(amount);
	  
	  //add to the transaction list
    // ListOfAllTransactions.add(new Transaction("crebit", amount));
    addTransaction("credit", amount);
	  
	  //update the last debit date
	  lastCreditTime = updateTransactionTime();
  }
  
  // this method has a long method smell
  public void DebitTransaction(int amount) {
    //reduce the amount
    deposite(-amount);
	  
	  //add to the transaction list
	  // ListOfAllTransactions.add(new Transaction("debit", amount));
    addTransaction("dedit", amount);
	  
	  //update the last debit date
    lastDebitTime = updateTransactionTime();
  }

}                                                                                                                                                                                                       
