package September;

public class RemoveDuplicates_II {

    public static void main(String[] args) {
        RemoveDuplicates_II removeDuplicates = new RemoveDuplicates_II();

        removeDuplicates.removeDuplicates(0, 0, 1, 1, 1, 1, 2, 3, 3);
    }

    public int removeDuplicates(int... nums) {
        int j = 0, factor = 1;

        for (int i = 1; i < nums.length; i++) {
            while(nums[i] == nums[i++ - 1]) factor++;
            if(factor > 2) {
                nums[(j += 2)] = nums[i];
            }
            else j += 2;
        }
        System.out.println(j);
        return j;
    }
}
