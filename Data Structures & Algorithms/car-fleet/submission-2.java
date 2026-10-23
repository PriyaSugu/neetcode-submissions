class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int[][] times = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            times[i][0] = position[i];
            times[i][1] = speed[i];
        }

        Arrays.sort(times, (a,b) -> Integer.compare(b[0],a[0]));

        for(int[] time : times){
            stack.push((double) (target - time[0]) / time[1]);
            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)){
                stack.pop();
            }
        }

        return stack.size();
    }
}
