package August;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] A = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(containerWithMostWater.maxArea(A));
    }

    public int maxArea(int[] height) {
        int area = 0, left = 0, right = height.length - 1;
        while (left < right) {
            area = max(area, (right - left) * (min(height[left], height[right])));

            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return area;
    }

    private static int max(int A, int B) {
        return A > B ? A : B;
    }

    private static int min(int A, int B) {
        return A < B ? A : B;
    }
}
