package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book(1, "Name", 20, "Author1");
    private Book book2 = new Book(2, "Name", 100, "Author3");
    private Book book3 = new Book(3, "Name3", 200, "Author3");
    private Smartphone smartphone1 = new Smartphone(1, "Samsung", 200, "Manufacture1");
    private Smartphone smartphone2 = new Smartphone(2, "Samsung", 400, "Manufacture2");
    private Smartphone smartphone3 = new Smartphone(3, "Nokia", 500, "Manufacture2");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }


    @Test
    void searchBookByNameIfOneProduct() {
        String text = "Name3";
        Product[] expected = new Product[]{book3};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByNameIfTwoProduct() {
        String text = "Name";
        Product[] expected = new Product[]{book1, book2};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByNameIfNotProduct() {
        String text = "Not Product";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByAuthorIfOneProduct() {
        String text = "Author1";
        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }
    @Test
    void searchBookByAuthorIfTwoProduct() {
        String text = "Author3";
        Product[] expected = new Product[]{book2, book3};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }
    @Test
    void searchBookByAuthorIfNotProduct() {
        String text = "Not author";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchSmartphoneByNameIfNotProduct(){
        String text = "Not Product";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }
    @Test
    void searchSmartphoneByNameIfOneProduct(){
        String text = "Nokia";
        Product[] expected = new Product[]{smartphone3};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }
    @Test
    void searchSmartphoneByNameIfTwoProduct(){
        String text = "Samsung";
        Product[] expected = new Product[]{smartphone1, smartphone2};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }
    @Test
    void searchSmartphoneByManufacturerIfOneProduct(){
        String text = "Manufacture1";
        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }
    @Test
    void searchSmartphoneByManufacturerIfTwoProduct(){
        String text = "Manufacture2";
        Product[] expected = new Product[]{smartphone2, smartphone3};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchSmartphoneByManufacturerIfNotProduct(){
        String text = "Not Manufacture";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

}