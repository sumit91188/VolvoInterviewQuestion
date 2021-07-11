package reference;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;

/**
 * @author Sumit Deo
 * @Date 7/10/21
 * @Project VolvoInterviewQuestion
 * @Comments SoldProduct model object
 */

@Value
@AllArgsConstructor
public class SoldProduct {
    String name;
    BigDecimal price;
    String currency;
}
