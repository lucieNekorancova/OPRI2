import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class OrderSystemTest {
    private OrderSystem system;

    @BeforeEach
    void setUp() throws Exception {
        system = new OrderSystem();

        Customer c1 = new Customer("Ivan Chlap", "Ivan@email.com");
        Order order1 = new Order(LocalDate.now(), c1);
        order1.addProduct(new Product("Laptop", 1, 20000));
        order1.addProduct(new Product("Mouse", 2, 500)); // Total 21,000

        Customer c2 = new Customer("Marketa zena", "Marketa@email.cz");
        Order order2 = new Order(LocalDate.now(), c2);
        order2.addProduct(new Product("Mouse", 5, 500));
        order2.addProduct(new Product("Keyboard", 1, 1000)); // Total 3,500

        system.addOrder(order1);
        system.addOrder(order2);
    }

    @Test
    void testTotalOrdersValue() {
        assertEquals(24500.0, system.getTotalOrdersValue(), 0.01);
    }

    @Test
    void testAverageOrderValue() {
        assertEquals(12250.0, system.getAverageOrderValue(), 0.01);
    }

    @Test
    void testMostSoldProduct() {
        assertEquals("Mouse", system.getMostSoldProduct());
    }
}
