package ru.netology.product.errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    private ShopRepository shopRepository;

    @BeforeEach
    public void set() {
        shopRepository = new ShopRepository();
        shopRepository.add(new Product(1, "Milk", 69));
        shopRepository.add(new Product(2, "Meat" , 899));
        shopRepository.add(new Product(3, "Coffee", 179));
        shopRepository.add(new Product(4, "Bread", 39));
    }

    @Test
    public void deleteID() {
        shopRepository.remove(3);
        Product[] products = shopRepository.findAll();
        Assertions.assertEquals(3, products.length);
    }

    @Test
    public void testException() {
        Product[] products = shopRepository.findAll();
        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.remove(100);
        });
    }
}
