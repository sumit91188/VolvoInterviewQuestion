package question;

import reference.EURExchangeService;
import reference.SimpleSoldProduct;
import reference.SoldProduct;
import reference.SoldProductsAggregate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sumit Deo
 * @Date 7/10/21
 * @Project VolvoInterviewQuestion
 * @Comments A simple aggregator for a report, which will hold sold products and sum of their prices converted to EURO currency.
 */
public class SoldProductsAggregator {
    private final EURExchangeService exchangeService;

    SoldProductsAggregator(EURExchangeService EURExchangeService) {
        this.exchangeService = EURExchangeService;
    }

    SoldProductsAggregate aggregate(Stream<SoldProduct> products) {
        if (products == null) {
            products = new ArrayList<SoldProduct>().stream();
        }

        List<SimpleSoldProduct> simpleSoldProductList = products.filter(soldProduct -> ! exchangeService.rate(soldProduct.getCurrency()).isEmpty()
                && exchangeService.rate(soldProduct.getCurrency()).get().signum() > 0)
                .map(soldProduct -> new SimpleSoldProduct(soldProduct.getName(),
                        soldProduct.getPrice().multiply(exchangeService.rate(soldProduct.getCurrency()).get())))
                .collect(Collectors.toList());

        BigDecimal priceSum = simpleSoldProductList.stream().map(SimpleSoldProduct::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        return new SoldProductsAggregate(simpleSoldProductList, priceSum);
    }
}
