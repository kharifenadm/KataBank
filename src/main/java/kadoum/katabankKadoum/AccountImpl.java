package kadoum.katabankKadoum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountImpl implements IAccount{

	private Integer id;
	private String bankname;
	private BigDecimal savings;
	private List<OperationImpl> operationLst = new ArrayList<OperationImpl>();
	
	
	public AccountImpl(Integer id, String bankname, BigDecimal savings) {
		super();
		this.id = id;
		this.bankname = bankname;
		this.savings = savings;
	}
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public BigDecimal getSavings() {
		return savings;
	}
	public void setSavings(BigDecimal savings) {
		this.savings = savings;
	}
		
	
	public List<OperationImpl> getOperationLst() {
		return operationLst;
	}

	public void setOperationLst(List<OperationImpl> operationLst) {
		this.operationLst = operationLst;
	}




	private void updateHistoric(BigDecimal amount,BigDecimal balance){
		OperationImpl op = new OperationImpl(OperationImpl.Type.W,(new Date()).hashCode(),amount,new Date(),balance);
		this.operationLst.add(op);
	}


	@Override
	public BigDecimal addAmount(BigDecimal amount) {
		if(savings!=null){
		this.savings = this.savings.add(amount);
		}else{
			this.savings =amount;
		}
		updateHistoric(amount, savings);
		return this.savings;
	}

	@Override
	public BigDecimal sustractAmount(BigDecimal amount) {
		if(savings!=null){
		this.savings = this.savings.subtract(amount);
		}else{
			this.savings =amount.negate();
		}
		
		updateHistoric(amount, savings);
		return this.savings;
	}




	@Override
	public String checkHistoric() {
		StringBuilder st = new StringBuilder(); 
		for (OperationImpl op: this.operationLst) {
			st.append(op.toString());
			st.append("\n");
		}
		return st.toString();
	}
	
	
	
	
	
	
	
}
