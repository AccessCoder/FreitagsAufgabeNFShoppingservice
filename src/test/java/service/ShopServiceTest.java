package service;

import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;
import repo.OrderRepo;
import repo.ProductRepo;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ShopServiceTest {

    @Test
    void orderProducts() {
        //GIVEN
        List<Product> products = List.of(
                new Product("1", "Shampoo"),
                new Product("2", "Haargel"),
                new Product("3", "Föhn")
        );
        ProductRepo productRepo = new ProductRepo(products);
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //WHEN
        Order actual = shopService.orderProducts(List.of("1", "3"));

        //THEN
        List<Product> expected = List.of(
                new Product("1", "Shampoo"),
                new Product("3", "Föhn")
        );
        assertEquals(expected, actual.getProductList());
    }

    @Test
    void testOrderProducts() {
        //GIVEN
        List<Product> products = List.of(
                new Product("1", "Shampoo"),
                new Product("2", "Haargel"),
                new Product("3", "Föhn")
        );
        ProductRepo productRepo = new ProductRepo(products);
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        try {

            //WHEN
            shopService.orderProducts(List.of("1", "4"));
            fail();
        } catch (NoSuchElementException actual) {
            //THEN
            assertEquals("Product with Id not found. Id: 4", actual.getMessage());
        }

    }
}
