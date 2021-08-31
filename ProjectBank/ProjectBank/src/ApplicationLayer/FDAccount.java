package ApplicationLayer;
import DataLayer.*;

public class FDAccount extends Accounts {
	
	double mainBalance,discountAmount=0;
	static int count=0;
	public FDAccount(AccountHolder obj) {
		super(obj);
		obj.setAccTypeId(3);
	}
	public void debit(int accNo,double amount)
	{
		System.out.println("Transaction Failed! Cant debit amount in this type of Account"+"\n");
	}
	public void credit(int accNo,double amount)
	{
		if(count==0)
		{
		mainBalance=getMainBalance(accNo);
		mainBalance=mainBalance+amount;
		changeMainBalance(accNo,mainBalance);
		System.out.println(amount+" :Credited Successfully");
		createCoupon(accNo,amount);
		System.out.println("Available Balance is: "+mainBalance+"\n");
		count++;
		}
		else if(count>1)
		{
			System.out.println("Transaction Failed! Cant credit amount more than once in this type of Account"+"\n");
		}
		else
		{
			System.out.println("Transaction Failed! Please visit your nearby branch"+"\n");
		}
	}
	@Override
	public void transferAmount(int accNo,int dest_accNo,String phoneNo,double amount) {
		System.out.println("Sorry! This service is not available for this type of Account"+"\n");
	}
	public void createCoupon(int accNo,double amount)
	{
		double discountPercentage=6;
		amount=(double)(discountPercentage *amount)/100;
		accountHolder.addCoupons(accNo, amount);
	}
	public void displayCoupon(int accNo)
	{
		System.out.println("Congratulations!! You have won "+accountHolder.getCoupons(accNo)+" worth of Coupon at KFC!!"+"\n");
	}

}
