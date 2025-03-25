

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        int floorVal = -1, ceilVal = -1;
        int floorDiff = Integer.MAX_VALUE, ceilDiff = Integer.MAX_VALUE;

        for (int num : arr) {
            // Updating the ceil if the current element is greater than or equal to x
            // and the difference is smaller
            if (num >= x && ceilDiff > (num - x)) {
                ceilDiff = num - x;
                ceilVal = num;
            }
            // Updating the floor if the current element is smaller than or equal to x
            // and the difference is smaller
            if (num <= x && floorDiff > (x - num)) {
                floorDiff = x - num;
                floorVal = num;
            }
        }

        return new int[] {floorVal, ceilVal};
    }
}
