
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

public class ShootTheAccount {
  private int balance = 0;
  private List<Transaction> ListOfAllTransactions = new ArrayList<Transaction>();
  private String lastDebitTime;
  
  public ShootTheAccount () {
  }

  public ShootTheAccount (int balance) {
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
  public void DebitTransaction(int amount) {
	  
	  if (balance >= 500) {
      //reduce the amount
      deposite(-amount);
		  // balance = balance - amount;
	  
		  //add to the transaction list
      // ListOfAllTransactions.add(new Transaction("debit", amount));
      addTransaction("debit", amount);
      
		  //update the last debit date
		  // Calendar cal = cal();
      
      // lastDebitTime = cal.get(Calendar.DATE) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR);  
      lastDebitTime = updateTransactionTime();
	  }	  
  }
  
  // this method has a long method smell
  public void Transfer(int amount, ShootTheAccount Benf) {
    
    if (balance >= 500) {
      //reduce the amount
      // balance = balance - amount;
      // deposite(-amount);
      
		  // //add to the transaction list
      // addTransaction("debit", amount);
		  // // ListOfAllTransactions.add(new Transaction("debit", amount));
      
		  // //update the last debit date
      // // Calendar cal = cal();
		  // // Calendar cal = Calendar.getInstance();
	  
      // // lastDebitTime = cal.get(Calendar.DATE) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR);  
      // lastDebitTime = updateTransactionTime();
      DebitTransaction(amount);
		  Benf.CreditTransaction(amount);
	  }	  
  }
  
  public void sendWarning() {
	  if (balance < 500 && this.type == "personal"){
		  System.out.println("Balance must be more than 500, please deposit");
    }
  }	  
}                                                                                                                                                                                                       
