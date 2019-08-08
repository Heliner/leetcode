import java.util.ArrayList;
import java.util.TreeMap;

public class leetcode5149 {
    static class SnapshotArray {
        int ser = 0;
        ArrayList<TreeMap<Integer, Integer>> arr = null;

        public SnapshotArray(int length) {
            arr = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                TreeMap<Integer, Integer> map = new TreeMap<>();
                map.put(ser, 0);
                arr.add(map);
            }
        }

        //直接设置到最后一个
        public void set(int index, int val) {
            TreeMap<Integer, Integer> map = arr.get(index);
            map.put(ser, val);
        }


        //返回快照id，并生成新的快照
        public int snap() {
            int old = ser;
            ser++;
            return old;
        }

        //通过比较快照中的snap_id 和snap_id 找到快照 -->1 ->>2   不修改就不创建新的节点
        public int get(int index, int snap_id) {
            TreeMap<Integer, Integer> map = arr.get(index);
            //key <= snap_id keys: 0 1 2 4 6 7  snap_id = 3  从右向左进行查找 0 1 2 4X 选择2
            return map.floorEntry(snap_id).getValue();
        }

    }

}
