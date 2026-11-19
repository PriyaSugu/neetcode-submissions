class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] time = new int[n][2];

        for(int i = 0; i < n; i++){
            time[i][0] = position[i];
            time[i][1] = speed[i];
        }

        Arrays.sort(time, (a,b) -> Integer.compare(b[0],a[0]));

        double prevTime = 0;
        int fleet = 0;

        for(int[] t: time){
            double currTime = (double) (target - t[0]) / t[1];
            if(prevTime < currTime){
                fleet++;
                prevTime = currTime;
            }
        }

        return fleet;
    }
}
