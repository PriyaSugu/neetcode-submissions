class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] time = new int[n][2];

        for(int i = 0; i < n; i++){
            time[i][0] = position[i];
            time[i][1] = speed[i];
        }

        Arrays.sort(time, (a,b) -> Integer.compare(b[0], a[0]));

        double prevTime = (double)(target - time[0][0]) / time[0][1];
        int fleet = 1;

        for(int i = 1; i < n; i++){
            double currTime = (double)(target - time[i][0]) / time[i][1];
            if(prevTime < currTime){
                fleet++;
                prevTime = currTime;
            }
        }

        return fleet;
    }
}
