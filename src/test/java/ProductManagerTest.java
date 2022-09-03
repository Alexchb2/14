import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository products = new ProductRepository();
    ProductManager manager = new ProductManager(products);

    public Product product1 = new Book(3,"Book", 200, "author1");
    public Product product2 = new Book(4,"Book1", 200, "author2");
    public Product product3 = new Smartphone(4,"Smartphone", 200, "author");
    public Product product4 = new Smartphone(4,"Smartphone1", 200, "author2");


    @BeforeEach
    public void setUp(){
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
    }
    @Test
    public void searchNameProducts() {
        Product[] expected = {product2};
        Product[] actual = manager.searchBy("Book1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAuthorProducts() {
        Product[] expected = {product2, product4};
        Product[] actual = manager.searchBy("author2");

        Assertions.assertArrayEquals(expected, actual);
    }
    
}
