//动态规划
public class DynamicProgramming {

    public static void main(String[] args) {
        int[][] nums = { {0, 0, 0}
                        ,{0, 0, 0}
                        ,{0, 0, 0}};
        int result = dynamicProgramming(nums);
        System.out.println(result);
    }

    public static int dynamicProgramming(int[][] obstacleGrid) {
        int y = obstacleGrid.length;
        int x = obstacleGrid[0].length;
        int[] f = new int[x];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < y; ++i) {
            for (int j = 0; j < x; ++j) {
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[x - 1];

    }
}
