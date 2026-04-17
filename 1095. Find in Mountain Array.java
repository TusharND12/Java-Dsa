class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        int peak = start;

        int ans = binarySearch(mountainArr, target, 0, peak, true);
        if (ans != -1)
            return ans;

        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
    }

    int binarySearch(MountainArray arr, int target, int start, int end, boolean asc) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = arr.get(mid);

            if (val == target)
                return mid;

            if (asc) {
                if (target < val)
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (target < val)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}