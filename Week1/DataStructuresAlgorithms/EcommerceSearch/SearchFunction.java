import java.util.Arrays;

public class SearchFunction {

    // Linear Search: O(N) time complexity
    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product.getProductId().equals(targetId)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search: O(log N) time complexity
    // Requires the array to be sorted by productId
    public static Product binarySearch(Product[] products, String targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(targetId);

            if (comparison == 0) {
                return products[mid];
            }
            if (comparison < 0) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product("P105", "Laptop", "Electronics"),
                new Product("P101", "Smartphone", "Electronics"),
                new Product("P104", "Desk", "Furniture"),
                new Product("P102", "Chair", "Furniture"),
                new Product("P103", "Notebook", "Stationery")
        };

        String searchId = "P104";

        System.out.println("--- Linear Search ---");
        Product foundLinear = linearSearch(products, searchId);
        System.out.println(foundLinear != null ? "Found: " + foundLinear : "Product not found.");

        System.out.println("\n--- Binary Search ---");
        // Binary search requires a sorted array
        Arrays.sort(products);
        Product foundBinary = binarySearch(products, searchId);
        System.out.println(foundBinary != null ? "Found: " + foundBinary : "Product not found.");

        System.out.println("\n--- Analysis ---");
        System.out.println("Big O notation helps analyze worst-case, best-case, and average-case time complexities.");
        System.out.println("Linear Search: O(1) best, O(N) average, O(N) worst case. Suitable for small or unsorted data.");
        System.out.println("Binary Search: O(1) best, O(log N) average, O(log N) worst case. Much faster for large datasets, but requires data to be sorted first.");
    }
}
