package kadoum.katabankKadoum;
import java.math.BigDecimal;

public class ClientImpl implements IClient{
	private String name;
	private AccountImpl account;
	
	public ClientImpl(String nm, AccountImpl acnt){
		this.name = nm;
		this.account = acnt;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AccountImpl getAccount() {
		return account;
	}
	public void setAccount(AccountImpl account) {
		this.account = account;
	}
	
	@Override
	public void deposit(BigDecimal amount) {
		if(this.account!=null && amount!= null){
			this.account.addAmount(amount);	
		}	
		
	}
	
	@Override
	public void withdrawal(BigDecimal amount) {
		if(this.account!=null && amount!= null){
			this.account.sustractAmount(amount);
		}
		
	}


	@Override
	public String checkAccountHistoric() {		
		return this.account.checkHistoric();
	}
	
	
	
}
