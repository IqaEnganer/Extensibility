package repository;


import domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product item) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeAll() {
        Product[] product = new Product[0];
        products = product;
    }

    public void removeById(int id) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }

    int numberDisplayedFilms = 10;

    public ProductRepository() {
    }

    public ProductRepository(int numberDisplayedFilms) {
        this.numberDisplayedFilms = numberDisplayedFilms;
    }

    public Product[] findAllFixReverse() {
        Product[] product = findAll();
        int resultLength;
        if (product.length < numberDisplayedFilms) {
            resultLength = product.length;
        } else {
            resultLength = numberDisplayedFilms;
        }
        Product[] tmp = new Product[resultLength];
        for (int i = product.length - resultLength; i < product.length; i++) {
            int index = product.length - i + (product.length - resultLength - 1);
            tmp[i - (product.length - resultLength)] = product[index];
        }
        return tmp;
    }


}
