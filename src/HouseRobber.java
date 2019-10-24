public class HouseRobber {
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == 0) {
                    rowhelperincr(matrix, i, j);
                    rowhelperdecr(matrix, i, j);
                    colhelperincr(matrix, i, j);
                    colhelperdecr(matrix, i, j);
                    break;
                }
            }
        }


    }
    public static void rowhelperincr(int[][] matrix, int i, int j) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(i > rows - 1 || i < 0) return;
        matrix[i][j] = 0;
        rowhelperincr(matrix, i+1,j);
    }
    public static void rowhelperdecr(int[][] matrix, int i, int j) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(i > rows - 1 || i < 0) return;
        matrix[i][j] = 0;
        rowhelperdecr(matrix, i-1, j);
    }
    public static void colhelperincr(int[][] matrix, int i, int j) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(j > cols - 1 || j < 0) return;
        matrix[i][j] = 0;
        colhelperincr(matrix, i,j+1);
    }
    public static void colhelperdecr(int[][] matrix, int i, int j) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(j > cols - 1 || j < 0) return;
        matrix[i][j] = 0;
        colhelperdecr(matrix, i,j-1);
    }
    private static int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i-1]);
        }
        return dp[nums.length - 1];
    }
    public static void main(String[] args) {
//        int[] arr = {1,2,1,1};
//        int sum = rob(arr);
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setZeroes(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
