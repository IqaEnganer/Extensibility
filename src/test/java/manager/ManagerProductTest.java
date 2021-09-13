package manager;

import domain.Book;
import domain.Product;
import domain.SmartPhone;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import java.util.PrimitiveIterator;
import java.util.prefs.PreferencesFactory;

import static org.junit.jupiter.api.Assertions.*;

class ManagerProductTest {
    private ProductRepository repository = new ProductRepository();
    private ManagerProduct manager = new ManagerProduct(repository);
    private Book b = new Book(1, "Гибкое мышление", 800, "Аноним");
    private Book b1 = new Book(2, "Анжелика", 700, "Аноним");
    private Book b2 = new Book(3, "Гарри Поттер", 10000, "Шикомару");
    private Book b3 = new Book(4, "Дракон", 500, "Давид Дзен");
    private Book b4 = new Book(5, "Гори в аду", 700, "Лиза Нум");
    private Book b5 = new Book(6, "Адреналин", 600, "Rush");
    private Book b6 = new Book(7, "Гибкий утенок", 200, "Аист");
    private Book b7 = new Book(8, "Карие руки", 400, "Author");
    private Book b8 = new Book(9, "Ногти во мгле", 500, "Author");
    private Book b9 = new Book(10, "Прах Учих", 100, "Author");
    private Book b10 = new Book(11, "Карандаш между ног", 1200, "Author");
    private SmartPhone s = new SmartPhone(16, "Light-Phone", 15000, "Japan");
    private SmartPhone s1 = new SmartPhone(15, "Summer", 15000, "Russia");
    private SmartPhone s2 = new SmartPhone(17, "Som-Phone", 15000, "Russia");

    @BeforeEach
    public void setUp() {
        manager.add(b);
        manager.add(b1);
        manager.add(b2);
        manager.add(b3);
        manager.add(b4);
        manager.add(b5);
        manager.add(b6);
        manager.add(b7);
        manager.add(b8);
        manager.add(b9);
        manager.add(b10);
        manager.add(s);
        manager.add(s1);
        manager.add(s2);
    }

    @Test
    // Поиск книги по автору
    public void shouldBookByAuthor() {
        assertArrayEquals(new Product[]{b6}, manager.searchBy("Аист"));
        assertArrayEquals(new Product[]{b5},manager.searchBy("Rush"));
    }

    @Test
    public void shouldBookByName() {
        assertArrayEquals(new Product[]{b3}, manager.searchBy("Дракон"));
    }

    @Test
    public void shouldSmartphoneByManufactures() {
        assertArrayEquals(new Product[]{s1, s2}, manager.searchBy("Russia"));
    }

    @Test
    public void shouldSmartphoneByName() {
        assertArrayEquals(new Product[]{s1}, manager.searchBy("Summer"));
    }

    @Test
    public void shouldSearchNull() {
        assertArrayEquals(new Product[0], manager.searchBy("Gorilla"));
    }

    @Test
    public void shouldSeveralProduct() {
        assertArrayEquals(new Product[]{b7, b8, b9, b10}, manager.searchBy("Author"));
    }
}