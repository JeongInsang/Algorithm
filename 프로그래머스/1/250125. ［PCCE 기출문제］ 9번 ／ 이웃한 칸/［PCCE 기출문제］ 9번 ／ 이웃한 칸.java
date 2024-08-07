class Solution {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        
        for(int d = 0; d < 4; d++){
            int nr = h + dr[d];
            int nc = w + dc[d];

            if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length){
                if(board[nr][nc].equals(color)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}