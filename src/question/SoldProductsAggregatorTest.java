package question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reference.EURExchangeService;
import reference.SoldProduct;
import reference.SoldProductsAggregate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Sumit Deo
 * @Date 7/10/21
 * @Project VolvoInterviewQuestion
 * @Comments Unit test for SoldProductsAggregator.java
 */
class SoldProductsAggregatorTest {

    SoldProductsAggregator objectUnderTest;
    Stream<SoldProduct> soldProducts;
    SoldProduct soldProduct1;
    SoldProduct soldProduct2;
    SoldProduct soldProduct3;
    SoldProduct soldProduct4;

    List<SoldProduct> soldProductList;

    EURExchangeService eurExchangeService;

    @BeforeEach
    void setUp() {
        soldProduct1 = new SoldProduct("p1", new BigDecimal(100), "USD");
        soldProduct2 = new SoldProduct("p2", new BigDecimal(200), "INR");
        soldProduct3 = new SoldProduct("p3", new BigDecimal(300), "USD");
        soldProduct4 = new SoldProduct("p4", new BigDecimal(400), "CAD");

        soldProductList = new ArrayList<>();
        soldProductList.add(soldProduct1);
        soldProductList.add(soldProduct2);
        soldProductList.add(soldProduct3);
        soldProductList.add(soldProduct4);

        soldProducts = soldProductList.stream();

        eurExchangeService = new EURExchangeService();
        objectUnderTest = new SoldProductsAggregator(eurExchangeService);
    }

    @Test
    void aggregate_happy_path() {
        SoldProductsAggregate soldProductsAggregate = objectUnderTest.aggregate(soldProducts);
        assertEquals(3, soldProductsAggregate.getProducts().size());
        assertEquals(420, soldProductsAggregate.getTotal().intValue());
    }

    @Test
    void aggregate_negative_case1() {
        SoldProductsAggregate soldProductsAggregate = objectUnderTest.aggregate(null);
        assertEquals(0, soldProductsAggregate.getProducts().size());
        assertEquals(0, soldProductsAggregate.getTotal().intValue());
    }

    @Test
    void aggregate_negative_case2() {
        soldProduct4 = new SoldProduct("p4", new BigDecimal(400), "CAD");
        soldProductList = new ArrayList<>();
        soldProductList.add(soldProduct4);

        soldProducts = soldProductList.stream();

        SoldProductsAggregate soldProductsAggregate = objectUnderTest.aggregate(soldProducts);
        assertEquals(0, soldProductsAggregate.getProducts().size());
        assertEquals(0, soldProductsAggregate.getTotal().intValue());
    }
}