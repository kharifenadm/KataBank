package kadoum.katabankKadoum;
import java.math.BigDecimal;

public interface IClient {
	
	public void deposit (BigDecimal amount);
	public void withdrawal(BigDecimal amount);
	public String checkAccountHistoric();
	
}
