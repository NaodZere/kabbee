package OnlineBankingSystem.TesfaSolutions.model;

import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class Account {
	long accountnumber;
	Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();

	@ManyToOne
	private User user;
	
	public Account (long accountnr){
		this.accountnumber = accountnr;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public double getBalance() {
		double balance=0;
		for (AccountEntry entry : entryList) {
			balance+=entry.getAmount();
		}
		return balance;
	}
	public void deposit(double amount){
		AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "", "");
		entryList.add(entry);
	}
	public void withdraw(double amount){
		AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
		entryList.add(entry);
	}

	private void addEntry(AccountEntry entry){
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description){
		AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, ""+toAccount.getAccountnumber(), toAccount.getUser().getFirstName());
		AccountEntry toEntry = new AccountEntry(new Date(), amount, description, ""+toAccount.getAccountnumber(), toAccount.getUser().getFirstName());
		entryList.add(fromEntry);
		toAccount.addEntry(toEntry);
	}
	
	public User getUser() {
		return new User();
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	// this is under review

}
