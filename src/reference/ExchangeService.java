package reference;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Sumit Deo
 * @Date 7/10/21
 * @Project VolvoInterviewQuestion
 * @Comments Exchange-Service interface to find exchange rate of a currency.
 */
public interface ExchangeService {
    Optional<BigDecimal> rate(String currency);
}
