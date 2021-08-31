package ApplicationLayer;
import DataLayer.*;

public class SavingAccount extends Accounts {
	double mainBalance,discountAmount=0;
	public SavingAccount(AccountHolder obj) {
		super(obj);
		obj.setAccTypeId(1);
	}
	
	public void debit(int accNo,double amount)
	{
		String action="Debited ";
		mainBalance=getMainBalance(accNo);
		if(amount<mainBalance)
		{
			mainBalance=mainBalance-amount;
			changeMainBalance(accNo,mainBalance);
			action=""+amount;
			accountHolder.setNotifications(accNo, action);
			System.out.println(amount+" :Debited Successfully");
			System.out.println("Available Balance is: "+mainBalance+"\n");
			
		}
		else
		{
			System.out.println("No suffcient balance");
			System.out.println("Available Balance is: "+mainBalance+"\n");
		}
	}
	public void credit(int accNo,double amount)
	{
		String action="Credited ";
		mainBalance=getMainBalance(accNo);
		mainBalance=mainBalance+amount;
		changeMainBalance(accNo,mainBalance);
		action=""+amount;
		accountHolder.setNotifications(accNo, action);
		System.out.println(amount+" :Credited Successfully");
		createCoupon(accNo,amount);
		System.out.println("Available Balance is: "+mainBalance+"\n");
	}
	@Override
	public void transferAmount(int accNo,int dest_accNo,String phoneNo,double amount) {
		super.transferAmount(accNo, dest_accNo,phoneNo, amount);
		String action="Transfered ";
		action=""+amount+" from accNo("+Integer.toString(accNo)+") to accNo("+Integer.toString(dest_accNo)+")";
		accountHolder.setNotifications(accNo, action);
	}
	public void createCoupon(int accNo,double amount)
	{
		double discountPercentage=2;
		amount=(double)(discountPercentage *amount)/100;
		accountHolder.addCoupons(accNo, amount);
	}
	public void displayCoupon(int accNo)
	{
		
		System.out.println("Congratulations!! You have won "+accountHolder.getCoupons(accNo)+" worth of Coupon at KFC!!\n");
	}

}
