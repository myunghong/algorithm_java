import java.util.*;
class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        Queue<Integer> Q = new ArrayDeque<>();
        char[][] board = new char[storage.length + 2][storage[0].length() + 2];
        
        for(int i = 1; i<storage.length+1; i++){
            for(int j = 1; j<storage[0].length()+1; j++){
                board[i][j] = storage[i-1].charAt(j-1);
            }
        }
        
        
        for(int i = 0; i<requests.length; i++){
            if(requests[i].length() == 1) {
                int[][] vis = new int[storage.length + 2][storage[0].length() + 2];
                Q.offer(0);
                vis[0][0] = 1;
                while(!Q.isEmpty()){
                    int temp = Q.poll();
                    int x = temp / board[0].length;
                    int y = temp % board[0].length;
                    for(int j = 0; j<4; j++){
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;
                        if(vis[nx][ny] != 0) continue;
                        if(board[nx][ny] == requests[i].charAt(0)) {
                            board[nx][ny] = ' ';
                        }
                        else if(board[nx][ny] == ' ' || board[nx][ny] == '\0'){
                            Q.offer(nx * board[0].length + ny);
                        }
                        vis[nx][ny] = 1;
                    }
                }
            }
            else {
                for(int q = 0; q<board.length; q++){
                    for(int p = 0; p<board[0].length; p++){
                        if(board[q][p] == requests[i].charAt(0)) {
                            board[q][p] = ' ';
                        }
                    }
                }
            }
        }
        
        for(int q = 0; q<board.length; q++){
            for(int p = 0; p<board[0].length; p++){
                if(board[q][p] != ' ' && board[q][p] != '\0') answer++;
            }
        }
        return answer;
    }
}