package ru.netology.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product product1 = new Product(1, "Versa1", 200);
    private Product product2 = new Product(2, "Versa2", 400);
    private Product product3 = new Product(3, "Versa3", 600);

    @BeforeEach
    void setUp() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
    }

    @Test
    public void shouldThrowException(){
        int idToRemove = 14;
        assertThrows(NotFoundException.class, () -> repository.removeById(idToRemove));
    }
    @Test
    public void shouldNotThrowException(){
        int idToRemove = 2;
        repository.removeById(idToRemove);
        Product[]expected = new Product[]{product1,product3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected,actual);
    }
}