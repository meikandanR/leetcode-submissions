class Solution {
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;
        int[][] ans = new int[m][n];
        int[] drow =new int[]{-1,-1,-1,0,1,1,1,0};
        int[] dcol = new int[]{-1,0,1,1,1,0,-1,-1}; 

        for(int i = 0 ; i < m ; i++){
            
            for(int j = 0; j < n; j++){
                
                int live = 0;
                int curcell = board[i][j];
                for(int k = 0 ; k< drow.length; k++){
                    int cr =  i + drow[k];
                    int cc = j + dcol[k];
                    if (cr >= 0 && cc >= 0 && cr < m && cc < n && board[cr][cc] == 1) {
                        live++;
                    }

                }
                if(board[i][j] ==1){
                if(live<2){
                    ans[i][j] = 0;
                }else if(live == 2 || live == 3){
                    ans[i][j] = 1;
                }else if(live > 3){
                    ans[i][j] = 0 ;
                }
                }else{
                    if(live == 3){
                        ans[i][j] =1;
                    }
                }


            }
        }

        for(int i  = 0 ; i < m ; i++){
            for(int j = 0 ; j <n ; j++){
                board[i][j] = ans[i][j];
            }
        }
    }
}