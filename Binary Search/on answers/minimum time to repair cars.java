class Solution {
    public long repairCars(int[] ranks, int cars) {
        long l = 1;
        long r=(long)1e14;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (timeIsSuff(ranks, cars, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    public boolean timeIsSuff(int[] ranks, int cars, long maxGiven) {
        long carsDone = 0;
        for (int r : ranks) {
            long c2 = maxGiven / r;
            long c = (long) Math.sqrt(c2);
            carsDone += c;
        }
        return carsDone >= cars;
    }
}
