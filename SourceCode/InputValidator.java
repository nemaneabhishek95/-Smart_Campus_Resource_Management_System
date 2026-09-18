/** Shared input validation utility. */
public final class InputValidator {
    private InputValidator() { }
    public static String required(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) throw new IllegalArgumentException(fieldName + " cannot be empty.");
        return value.trim();
    }
}
