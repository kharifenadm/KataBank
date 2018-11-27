package kadoum.katabankKadoum;
import java.math.BigDecimal;

public interface IAccount {

	public BigDecimal addAmount(BigDecimal amount);
	
	public BigDecimal sustractAmount(BigDecimal amount);
	
	public String checkHistoric();
	
	
}
