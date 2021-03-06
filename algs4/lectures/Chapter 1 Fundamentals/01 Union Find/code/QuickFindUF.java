public class QuickFindUF {
    private int[] id;
    private int count;

    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i; // set id of each oject to itself
        }
    }

    // check whether p and q are in the same component
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    public int find(int p) {
        validate(p);
        return id[p];
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pid = id[p];
        int qid = id[q];
        // p and q are already in the same component
        if (pid == qid)
            return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid)
                id[i] = qid;
        }
        count--;
    }

    public int count() {
        return count;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }
}