package Sort;

public class UnionSet {
    int[] sets = null;
    public int count = 0;

    public int find(int x) {
        int p = x;
        while (sets[p] != p) p = sets[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }


    public void union(int p, int q) {
        int ps = find(p);
        int qs = find(q);
        /*sets[ps]=qs*/
        sets[ps] = sets[qs];
        count--;

    }


    public int count() {
        return count;
    }

    public UnionSet(int N) {
        count = N;
        sets = new int[N];
        for (int i = 0; i < N; i++) {
            sets[i] = i;
        }
    }

}
