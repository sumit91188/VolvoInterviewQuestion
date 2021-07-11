package reference;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Sumit Deo
 * @Date 7/10/21
 * @Project VolvoInterviewQuestion
 * @Comments Implementation of an interface ExchangeService.java for currency Euro.
 */
public class EURExchangeService implements ExchangeService{
    @Override
    public Optional<BigDecimal> rate(String currency) {
        if (currency.equals("INR")) {
            return Optional.of(new BigDecimal(0.3));
        }
        else if (currency.equals("USD")) {
            return Optional.of(new BigDecimal(0.9));
        }
        else if (currency.equals("CAD")) {
            return Optional.of(new BigDecimal(-0.5));
        }
        return Optional.empty();
    }
}
