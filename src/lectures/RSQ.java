package lectures;

interface IRSQ {
    long sum(int l, int r);
}

public class RSQ implements IRSQ {

    int[] data;
    int blockNum;
    int[] blocks;

    public RSQ(int[] data) {
        this.data = data;
        int n = data.length;
        blockNum = (int) Math.sqrt(n) + 1;
        blocks = new int[blockNum];

        for (int i = 0; i < n; i++) {
            int blockIndex = i / blockNum;
            blocks[blockIndex] += data[i];
        }
    }

    @Override
    public long sum(int l, int r) {
        int lBlock = l / blockNum;
        int rBlock = r / blockNum;

        if (lBlock == rBlock) {
            long sum = 0;
            for (int i = l; i < r; i++) {
                sum += data[i];
            }
            return sum;
        }

        long sum = 0;

        // left part
        long endOfLeftBlock = (lBlock + 1) * blockNum;
        for (int i = l; i < endOfLeftBlock; i++) {
            sum += data[i];
        }

        // rightf part
        int startOfRightBlock = rBlock * blockNum;
        for (int i = startOfRightBlock; i < r; i++) {
            sum += data[i];
        }


        for (int i = lBlock + 1; i < rBlock; i++) {
            sum += data[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] data = {9,3,7,9,9,9,2,8};
        RSQ rsq = new RSQ(data);

        System.out.println(rsq.sum(1,1)); // 0
        System.out.println(rsq.sum(1,3)); // 10
        System.out.println(rsq.sum(2,4)); // 16
        System.out.println(rsq.sum(3,6)); // 27
    }
}
