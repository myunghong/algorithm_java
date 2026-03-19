package 메모장프로그램;

import java.util.*;

class UserSolution {
	int H, W, row, col, len;
	int[][] count;
	Deque<Character>[] memo;

	void init(int H, int W, char mStr[]) {
		this.H = H;
		this.W = W;
		len = 0;
		memo = new ArrayDeque[H];
		count = new int[H][26];
		for(int i = 0; i<H; i++) {
			memo[i] = new ArrayDeque<>();
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (mStr[i * W + j] == '\0')
					break;
				memo[i].addLast(mStr[i * W + j]);
				len++;
				count[i][mStr[i * W + j] - 'a']++;
			}
		}
		row = 0; // 현재 커서의 위치
		col = 0;
	}

	void insert(char mChar) {
		Deque<Character> Q = new ArrayDeque<>();
		int target = row * W + col;
		if(len == target) {
			memo[row].offer(mChar);

			count[row][mChar -'a']++;
			len++;
			col++;
			if(col == W) {
				col = 0;
				row++;
			}
			return;
		}
		int cnt = memo[row].size() - col;
		for(int i = 0; i<cnt; i++) {
			Q.offerFirst(memo[row].pollLast());
		}
		memo[row].offerLast(mChar);
		count[row][mChar -'a']++;
		len++;

		while(!Q.isEmpty()) {
			memo[row].offerLast(Q.pollFirst());
		}
		if(memo[row].size() > W) {
			for(int i = row; i<((len-1) / W); i++) {
				count[i+1][memo[i].peekLast() - 'a']++;
				count[i][memo[i].peekLast() - 'a']--;
				memo[i+1].offerFirst(memo[i].pollLast());
			}
		}
		col++;
		if(col == W) {
			col = 0;
			row++;
		}
	}

	char moveCursor(int mRow, int mCol) {
		int target = (mRow - 1) * W + mCol - 1;
		
		if(target >= len) {
			row = len / W;
			col = len  % W;
			return '$';
		}
		else {
			row = mRow - 1;
			col = mCol - 1;
			Deque<Character> Q = new ArrayDeque<>();
			for(int i = 0; i<col; i++) {
				Q.offerLast(memo[row].pollFirst());
			}
			Character ans = memo[row].peekFirst();
			while(!Q.isEmpty()) {
				memo[row].offerFirst(Q.pollLast());
			}
//			if(ans == null) System.out.println("col:" + col + " row:" + row + " memo:" + memo[row].size());
			return ans;
		}
	}

	int countCharacter(char mChar) {
		int cnt = 0;
		for(int i = row; i<=(len-1) / W; i++) {
				cnt += count[i][mChar-'a'];
		}
		Deque<Character> Q = new ArrayDeque<>();
		for(int i = 0; i<col; i++) {
			Q.offerLast(memo[row].pollFirst());
		}
		while(!Q.isEmpty()) {
			Character temp = Q.pollLast();
			if(temp == mChar) cnt--;
			memo[row].offerFirst(temp);
		}
		return cnt;
	}
}