/**
 * N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
 * <p>
 * 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
 * <p>
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
 * <p>
 * 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
 * <p>
 * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 * <p>
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 * <p>
 * <p>
 * <p>
 * 会有多少车队到达目的地?
 */
public class Solution853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int res = 0;
        int i = speed.length - 1;
        while (i >= 0) {
            //找出全部可以追上i的车
            int j = i - 1;
            while (j >= 0) {
                if (j >= 0 && canCatch(position, speed, j, i, target)) {
                    j -= 1;
                } else {
                    res++;
                    i = j;
                    break;

                }
            }

        }
        return res;
    }

    boolean canCatch(int[] position, int[] speed, int l, int r, int target) {
        if (position[l] == position[r])
            return true;

        if (speed[l] <= speed[r])
            return false;
        float t = (position[r] - position[l]) / (speed[l] - speed[r]);
        return t * speed[r] + position[r] <= target;
    }

    class per {
        int pos;
        int sp;

        public per(int pos, int sp) {
            this.pos = pos;
            this.sp = sp;
        }
    }

    public static void main(String[] args) {
        Solution853 s = new Solution853();
        System.out.println(s.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
        ;
    }
}
