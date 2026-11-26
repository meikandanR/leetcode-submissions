class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0 ;
        int dir= 0;

        int n = instructions.length();
        for(int i = 0 ; i < n ; i++){
            char c = instructions.charAt(i);
            if(c == 'G'){
                if(dir == 0 ){
                    y++;
                }else if(dir == 1){
                    x++;
                }else if(dir == 2){
                    y--;
                }else if(dir == 3){
                    x--;
                }
            }else if(c == 'L'){
                dir = ( dir + 3 )%4;
            }else{
                dir = ( dir + 1 )%4;
            }       
        }

        return ( x == 0 && y == 0 ) || dir !=0;
    }
}