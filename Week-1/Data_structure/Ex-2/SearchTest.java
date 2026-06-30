import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        // Setup mock product data
        Product[] products = {
            new Product("P103", "Wireless Mouse", "Electronics"),
            new Product("P105", "Mechanical Keyboard", "Electronics"),
            new Product("P101", "Gaming Monitor", "Electronics"),
            new Product("P104", "USB-C Hub", "Accessories"),
            new Product("P102", "Noise Cancelling Headphones", "Audio"),
            new Product("P106", "Leather Wallet", "Accessories")
        };

        System.out.println("=== Unsorted Products (used for Linear Search) ===");
        for (Product p : products) {
            System.out.println(p);
        }

        String searchId = "P104";
        System.out.println("\n--- Searching for " + searchId + " using Linear Search ---");
        long startLinear = System.nanoTime();
        Product foundLinear = SearchAlgorithms.linearSearch(products, searchId);
        long endLinear = System.nanoTime();
        System.out.println("Result: " + (foundLinear != null ? foundLinear : "Product Not Found"));
        System.out.println("Linear Search execution time: " + (endLinear - startLinear) + " ns");

        // Binary search requires a sorted array by productId
        System.out.println("\n=== Sorting Products by Product ID ===");
        Arrays.sort(products);
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println("\n--- Searching for " + searchId + " using Binary Search ---");
        long startBinary = System.nanoTime();
        Product foundBinary = SearchAlgorithms.binarySearch(products, searchId);
        long endBinary = System.nanoTime();
        System.out.println("Result: " + (foundBinary != null ? foundBinary : "Product Not Found"));
        System.out.println("Binary Search execution time: " + (endBinary - startBinary) + " ns");

        // Benchmarking over multiple iterations to demonstrate scalability
        int iterations = 1000000;
        System.out.println("\n=== Benchmarking: Running " + iterations + " searches ===");

        long startBenchLinear = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            SearchAlgorithms.linearSearch(products, "P106");
        }
        long endBenchLinear = System.nanoTime();
        long totalLinearTime = endBenchLinear - startBenchLinear;

        long startBenchBinary = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            SearchAlgorithms.binarySearch(products, "P106");
        }
        long endBenchBinary = System.nanoTime();
        long totalBinaryTime = endBenchBinary - startBenchBinary;

        System.out.println("Total time for " + iterations + " Linear Searches: " + (totalLinearTime / 1_000_000.0) + " ms");
        System.out.println("Total time for " + iterations + " Binary Searches: " + (totalBinaryTime / 1_000_000.0) + " ms");
        System.out.println("Average Linear Search time: " + ((double) totalLinearTime / iterations) + " ns");
        System.out.println("Average Binary Search time: " + ((double) totalBinaryTime / iterations) + " ns");
    }
}
