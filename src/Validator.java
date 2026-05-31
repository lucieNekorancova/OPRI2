public class Validator {
    public static void checkNotEmpty(String value, String fieldName) throws EmptyValueException {
        if (value == null || value.trim().isEmpty()) {
            throw new EmptyValueException("Value for '" + fieldName + "' cannot be empty.");
        }
    }

    public static void checkEmail(String email) throws InvalidEmailException, EmptyValueException {
        checkNotEmpty(email, "Email");
        if (!email.contains("@") || !(email.endsWith(".cz") || email.endsWith(".com"))) {
            throw new InvalidEmailException("Email must contain '@' and end with '.cz' or '.com'.");
        }
    }

    public static void checkProductName(String name) throws ShortNameException, EmptyValueException {
        checkNotEmpty(name, "Product name");
        if (name.trim().length() < 3) {
            throw new ShortNameException("Product name must have at least 3 characters.");
        }
    }

    public static void checkPositive(double value, String fieldName) throws NegativeValueException {
        if (value < 0) {
            throw new NegativeValueException("Value for '" + fieldName + "' cannot be negative.");
        }
    }
}