public class SearchAlgorithms {

    /**
     * Performs a Linear Search on the products array.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param products The array of products.
     * @param targetProductId The product ID to search for.
     * @return The Product if found, or null if not found.
     */
    public static Product linearSearch(Product[] products, String targetProductId) {
        if (products == null || targetProductId == null) {
            return null;
        }
        for (Product product : products) {
            if (product.getProductId().equalsIgnoreCase(targetProductId)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Performs a Binary Search on the products array.
     * Assumes the products array is sorted by productId.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     *
     * @param products The sorted array of products.
     * @param targetProductId The product ID to search for.
     * @return The Product if found, or null if not found.
     */
    public static Product binarySearch(Product[] products, String targetProductId) {
        if (products == null || targetProductId == null) {
            return null;
        }
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = products[mid].getProductId().compareToIgnoreCase(targetProductId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
