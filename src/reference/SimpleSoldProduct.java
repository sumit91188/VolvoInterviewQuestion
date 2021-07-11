package reference;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;

/**
 * @author Sumit Deo
 * @Date 7/10/21
 * @Project VolvoInterviewQuestion
 * @Comments SimpleSoldProduct model object
 */

@Value
@AllArgsConstructor
public class SimpleSoldProduct {
    String name;
    BigDecimal price;
}
