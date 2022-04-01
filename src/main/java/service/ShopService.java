package service;

import model.Order;
import model.Product;
import repo.OrderRepo;
import repo.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopService {

    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Order orderProducts(List<String> productIds){
        List<Product> productsToOrder = new ArrayList<>();
        for (String productId : productIds){
            Product productToAdd = getProduct(productId);
            productsToOrder.add(productToAdd);
        }
        String id = UUID.randomUUID().toString();
        return orderRepo.addOrder(new Order(id, productsToOrder));
    }

    public Product getProduct(String productId){
        return productRepo.getProduct(productId);
    }

    public List<Order> listOrders(){
        return orderRepo.listOrders();
    }
}
