package DataStructures.NewWork.LCArray;

import java.util.HashMap;
import java.util.Map;

public class SnapShotArrayHelper {
    public static void main(String[] args) {
        SnapshotArray array = new SnapshotArray(2);
        System.out.println(array.snap());
        System.out.println(array.get(1,0));
        System.out.println(array.get(0,0));
        array.set(1,8);
        System.out.println(array.get(1,0));

    }
}

class SnapshotArray {

    Map<Integer, Integer>[] mapArr;
    int snap = -1;
    int[] arr;

    public SnapshotArray(int length) {
        mapArr = new Map[length];
        arr = new int[length];
    }

    public void set(int index, int val) {
        if (mapArr[index] == null) {
            mapArr[index] = new HashMap<>();
        }
        arr[index] = snap;
        mapArr[index].put(snap, val);
    }

    public int snap() {
        snap++;
        return snap;
    }

    public int get(int index, int snap_id) {
        snap_id--;
        if (mapArr[index] == null) return 0;
        if (mapArr[index].containsKey(snap_id)) {
            return mapArr[index].get(snap_id);
        }
        int idx = arr[index];
        return mapArr[index].get(idx);
    }
}
