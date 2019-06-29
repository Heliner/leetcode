package today.二分;

public class Soultion1095 {
    static class MountainArray {

        public int get(int index) {
            return -1;
        }

        public int length() {
            return -1;
        }
    }

    static class Solution {
        public int findInMountainArray(int target, MountainArray mountainArr) {
            int len, maxIndex, left, right, mid, res;
            len = mountainArr.length();
            maxIndex = -1;
            left = 0;
            right = len - 1;
            mid = 0;
            maxIndex = searchMax(mountainArr, len - 1);
            System.out.println("maxIndex:" + maxIndex);
            res = searchT(mountainArr, 0, maxIndex, target, 1);
            System.out.println("res:" + res);

            if (-1 != res)
                return res;
            res = searchT(mountainArr, maxIndex + 1, len - 1, target, -1);
            return res;
        }

        int searchMax(MountainArray mountainArr, int maxIndex) {
            int res = -1;
            int left, right, mid;
            left = 0;
            right = maxIndex;
            while (left < right) {
                mid = left + (right - left) / 2;

                int leftVal, leftVal2;
                leftVal = mountainArr.get(left);

                leftVal2 = (left + 1) <= maxIndex ? mountainArr.get(left + 1) : -1;
                if (leftVal < leftVal2) {
                    left = mid + 1;
                } else
                    right = mid;
            }
            return left;
        }

        int searchT(MountainArray mountainArr, int start, int end, int target, int base) {
            if (start > end)
                return -1;
            int left, right, mid;
            left = start;
            right = end;

            while (left < right) {
                mid = left + (right - left) / 2;
                int midVal = mountainArr.get(mid);
//             if(target == midVal)
//                 return left;

                if (base * (Integer.compare(midVal, target)) < 0) {
                    left = midVal + 1;
                } else
                    right = midVal - 1;

            }
            return (target == mountainArr.get(left)) ? left : -1;
        }

    }

}
