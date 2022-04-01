package repo;

import model.Product;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductRepo {

    private final List<Product> products;

    public ProductRepo(List<Product> products) {
        this.products = products;
    }

    public List<Product> listProducts(){
        return products;
    }

    public Product getProduct(String id){
        for (Product product : products){
            if (product.getId().equals(id)){
                return product;
            }
        }
        throw new NoSuchElementException("Product with Id not found. Id: "+id);
    }
}
