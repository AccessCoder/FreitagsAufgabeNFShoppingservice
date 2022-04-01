package repo;

import model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepoTest {

    @Test
    @DisplayName("listProducts should return all available products")
    void testListProducts() {
        //GIVEN
        List<Product> products = List.of(
                new Product("1", "Shampoo"),
                new Product("2", "Haargel"),
                new Product("3", "Föhn")
        );
        ProductRepo productRepo = new ProductRepo(products);
        //WHEN
        List<Product> actual = productRepo.listProducts();

        //THEN
        assertEquals(products, actual);
    }

    @Test
    void testGetProductWithExistingId(){
        //GIVEN
        List<Product> products = List.of(
                new Product("1", "Shampoo"),
                new Product("2", "Haargel"),
                new Product("3", "Föhn")
        );
        ProductRepo productRepo = new ProductRepo(products);

        //WHEN
        Product actual = productRepo.getProduct("2");

        //THEN
        assertEquals(new Product("2", "Haargel"), actual);
    }

    @Test
    void testGetProductWithNonExistingId(){
        //GIVEN
        List<Product> products = List.of(
                new Product("1", "Shampoo"),
                new Product("2", "Haargel"),
                new Product("3", "Föhn")
        );
        ProductRepo productRepo = new ProductRepo(products);
        //WHEN

        //THEN
        assertThrows(NoSuchElementException.class, () -> productRepo.getProduct("4"));
    }

}
