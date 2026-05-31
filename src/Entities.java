import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) throws EmptyValueException, InvalidEmailException {
        Validator.checkNotEmpty(name, "Customer name");
        Validator.checkEmail(email);
        this.name = name;
        this.email = email;
    }
    public String getName() { return name; }
}

class Product {
    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) throws EmptyValueException, ShortNameException, NegativeValueException {
        Validator.checkProductName(name);
        Validator.checkPositive(quantity, "Quantity");
        Validator.checkPositive(price, "Price");
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public double getTotalPrice() { return quantity * price; }
}

class Order {
    private LocalDate date;
    private Customer customer;
    private List<Product> products;

    public Order(LocalDate date, Customer customer) {
        this.date = date;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() { return products; }
    public LocalDate getDate() { return date; }
    public Customer getCustomer() { return customer; }

    public double getOrderTotal() {
        return products.stream().mapToDouble(Product::getTotalPrice).sum();
    }
}
