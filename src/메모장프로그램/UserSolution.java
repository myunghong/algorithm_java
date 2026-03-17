package 메모장프로그램;
import java.util.*;
class UserSolution
{
	int H,W, row, col, idx;
	char[][] memo;
	void init(int H, int W, char mStr[])
	{
		this.H = H;
		this.W = W;
		idx = 0;
		memo = new char[H][W];
//		for(int i = 0; i<H; i++) {
//			memo[i] = new ArrayList<>();
//		}
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				if(mStr[i * W + j] == '\0') break;
				memo[i][j] = mStr[i * W + j];
				idx++;
			}
		}
		idx--;
		row = 0;
		col = 0;
	}
	
	void insert(char mChar)
	{
		Deque<Character> Q = new ArrayDeque<>();
		for(int i = row; i<=idx / W; i++) {
			for(int j = col; j<W; j++) {
				Q.offer(memo[i][j]);
			}
		}
//		if(row >= H || col >= W) System.out.println("오류발생  row: " + row + " col:" + col + " W:" + W + " idx: " + idx);
		memo[row][col] = mChar;
		col++;
		idx++;
		if(col >= W) {
			col = col - W;
			row++;
		}
		for(int i = row; i<=idx / W; i++) {
			for(int j = col; j<W; j++) {
				if(Q.isEmpty()) break;
				memo[i][j] = Q.poll();
			}
		}

	}

	char moveCursor(int mRow, int mCol)
	{
		if(mRow > idx / W) { // 마지막 줄로 이동하는 경우 or 그 이상으로 이동하는 경우
			if(mRow - 1 == idx / W) { //마지막 줄로 이동하는 경우
				if(mCol-1 > idx % W) { //현재 최대 글자 수를 넘는 경우
					row = mRow - 1;
					col = idx % W + 1;
					return '$';
				}
				else {
					row = mRow - 1;
					col = mCol - 1;
					return memo[row][col];
				}
			}
			else {
				row = idx / W;
				col = idx % W;
				return '$';
			}
			
		}
		else {
			
			row = mRow-1;
			col = mCol-1;
			return memo[row][col];
		}
	}

	int countCharacter(char mChar)
	{
		int cnt = 0;
		for(int i = row; i<H; i++) {
			for(int j = col; j<W; j++) {
				if(memo[i][j] == mChar) cnt++;
			}
		}
		return cnt;
	}
}