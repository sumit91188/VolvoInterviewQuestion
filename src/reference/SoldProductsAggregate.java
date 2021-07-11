package reference;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sumit Deo
 * @Date 7/10/21
 * @Project VolvoInterviewQuestion
 * @Comments SoldProductsAggregate model object
 */

@Value
@AllArgsConstructor
public class SoldProductsAggregate {
    List<SimpleSoldProduct> products;
    BigDecimal total;
}
