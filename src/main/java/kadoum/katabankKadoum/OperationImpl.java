package kadoum.katabankKadoum;
import java.math.BigDecimal;
import java.util.Date;

public class OperationImpl implements IOperation{

	static enum Type{W,D}
	
	private Integer id;
	private BigDecimal amount;
	private Date date;	
	private BigDecimal balance;
	
	public OperationImpl(Type t, Integer id, BigDecimal amount, Date date, BigDecimal bal) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.balance = bal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return " [Operation id=" + id + ", amount=" + amount + ", date=" + date + ", balance=" + balance + "]";
	}
	
	

}
