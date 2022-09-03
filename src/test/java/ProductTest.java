import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {

    public ProductRepository products = new ProductRepository();

    public Product product1 = new Book(3,"Book1", 200, "author1");
    public Product product2 = new Smartphone(4,"Book", 200, "author1");

    @BeforeEach
    public void setUp(){
        products.add(product1);
        products.add(product2);
    }

    @Test
    public void findProduct() {


        Product[] expected = {product1, product2};
        Product[] actual = products.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveProducts(){

        products.removeById(3);

        Product[] expected = {product2};
        Product[] actual = products.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveProducts2(){

        Assertions.assertThrows(NotFoundException.class, () ->{
            products.removeById(5);
        });

    }

}
