package August;
public class CanPlaceFlowers {
    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        int[] flowerbeds = { 1, 0, 0, 0, 1 };
        System.out.println(canPlaceFlowers.find(flowerbeds, 2));

    }

    public boolean find(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n == 0;
    }
}
