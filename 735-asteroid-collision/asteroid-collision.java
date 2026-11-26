class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;

        for (int i = 0; i < n; i++) {
            if (asteroids[i] > 0) {
                stack.add(asteroids[i]);
            } else {
                boolean alive = true;

                while(!stack.isEmpty() && stack.peek()>0){
                    if(stack.peek() < Math.abs(asteroids[i])){
                        stack.pop();
                    }else if(stack.peek() == Math.abs(asteroids[i])){
                        stack.pop();
                        alive = false;
                        break;
                    }else{
                        alive = false;
                        break;
                        
                    }
                }

                if(alive){
                    stack.add(asteroids[i]);
                }

            }
        }

        int[] ans = new int[stack.size()];

        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}