public class ArraysRecitation {
    static int hello = 0;

    public static void main(String[] args) {
        double[] doubles = new double[5];
        double[] doubles2 = {0.0, 0.0, 1.2, 13.2, 4.5};

        String[] suits = {"diamonds", "hearts", "clubs", "spades"};

        int[] ints = new int[100];

        for(int i = 0; i < ints.length; i++) {
            ints[i] = 2*i;
        }

        // for(int i = 0; i < ints.length; i++) {
        //     System.out.println(ints[i]);
        // }

        int[] test = {0, 3, 66, 12};
        int ans = max(1234567890, 0, 54, 43, 20, 10000);
        System.out.println(ans);

        int[][] grid = {{0, 1, 11},
                        {3, 4, 10}};
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }

    }

    public static int max(int x, int ... numbers) {
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

}
