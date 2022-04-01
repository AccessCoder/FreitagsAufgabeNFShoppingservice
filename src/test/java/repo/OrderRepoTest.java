package repo;

import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

public class OrderRepoTest {

    @Test
    void testAdd() {
        //GIVEN
        OrderRepo orderRepo = new OrderRepo();

        //WHEN
        orderRepo.addOrder(
                new Order("order1", List.of(
                        new Product("1", "Shampoo"),
                        new Product("2", "Haargel")
                ))
        );
        //THEN
        assertTrue(orderRepo.listOrders().contains(
                new Order("order1", List.of(
                        new Product("1", "Shampoo"),
                        new Product("2", "Haargel")
                ))));
    }

    @Test
    void testListOrders() {
        //GIVEN
        OrderRepo orderRepo = new OrderRepo();

        orderRepo.addOrder(
                new Order("order1", List.of(
                        new Product("1", "Shampoo"),
                        new Product("2", "Haargel")
                ))
        );
        orderRepo.addOrder(
                new Order("order2", List.of(
                        new Product("1", "Shampoo"),
                        new Product("3", "Föhn")
                ))
        );
        //WHEN
        List<Order> actual = orderRepo.listOrders();

        //THEN
        assertThat(actual, containsInAnyOrder(
                new Order("order1", List.of(
                        new Product("1", "Shampoo"),
                        new Product("2", "Haargel")
                )),
                new Order("order2", List.of(
                        new Product("1", "Shampoo"),
                        new Product("3", "Föhn")
                ))

        ));
        assertEquals(2, actual.size());
    }
}
