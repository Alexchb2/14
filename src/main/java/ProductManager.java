public class ProductManager {

    private ProductRepository products;

    public ProductManager(ProductRepository products) {
        this.products = products;
    }
    public void add(Product product) {
        products.add(product);
    }
    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : products.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().contains(search)) {
                return true;
            }
            return book.getName().contains(search);
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getAuthor().contains(search)) {
                return true;
            }
            return smartphone.getName().contains(search);
        }
        return false;
    }
}
