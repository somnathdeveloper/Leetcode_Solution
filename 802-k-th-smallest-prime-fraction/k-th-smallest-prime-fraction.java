class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        int n = arr.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double div = (double) arr[i] / arr[j];
                pq.offer(new double[]{div, (double) arr[i], (double) arr[j]});

                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        double[] ans = pq.poll();
        return new int[]{(int) ans[1], (int) ans[2]};
    }
}