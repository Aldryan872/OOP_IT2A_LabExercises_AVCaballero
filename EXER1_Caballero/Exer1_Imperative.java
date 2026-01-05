public class Imperative {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int sum = 0;
        int product = 1;

        // step-by-step instructions
        for (int num : numbers) {
            sum += num;
            product *= num;
        }

        double average = (double) sum / numbers.length;

        System.out.println("Sum = " + sum);
        System.out.println("Product = " + product);
        System.out.println("Average = " + average);
    }
}
