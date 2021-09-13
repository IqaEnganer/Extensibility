package manager;

import domain.Book;
import domain.Product;
import domain.SmartPhone;
import repository.ProductRepository;

public class ManagerProduct {


    private ProductRepository repository;


    public ManagerProduct() {
    }

    public ManagerProduct(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public void remove(int id) {
        repository.removeById(id);
    }

    public Product[] findAll() {
        return repository.findAll();
    }

    public void removeALl() {
        repository.removeAll();
    }

    public Product[] FindAllFixReverse() {
        return repository.findAllFixReverse();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }


}



