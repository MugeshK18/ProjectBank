package ApplicationLayer;

public interface ILoginCheck {
	public boolean cust_loginCheck(String loginId,String password);
	public boolean emp_loginCheck(String loginId,String password);
	public int getCustAccNo();
	public int getEmpId();
}
