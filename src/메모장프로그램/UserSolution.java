package 메모장프로그램;

import java.util.*;

class UserSolution {
	int H, W, idx, len;
	int[][] count;
	Deque<Character>[] memo;

	void init(int H, int W, char mStr[]) {
		this.H = H;
		this.W = W;
		int len = 0;
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
		idx = 0; // 현재 커서의 위치
		
	}

	void insert(char mChar) {
		Deque<Character> Q = new ArrayDeque<>();
		if(len == idx) {
			memo[idx / W].offer(mChar);
			len++;
			idx++;
			return;
		}
		int cnt = memo[idx / W].size() - idx % W;
		for(int i = 0; i<cnt; i++) {
			Q.offerFirst(memo[idx / W].pollLast());
		}
		memo[idx / W].offerLast(mChar);

		while(!Q.isEmpty()) {
			memo[idx / W].offerLast(Q.pollFirst());
		}
		if(memo[idx / W].size() >= W) {
			for(int i = (idx / W); i<((len-1) / W) - 1; i++) {
				memo[i+1].offerFirst(memo[i].pollLast());
			}
		}

		len++;
		idx++;
	}

	char moveCursor(int mRow, int mCol) {
		int target = (mRow - 1) * W + mCol - 1;
		
		if(target >= len) {
			idx = len;
			return '$';
		}
		else {
			idx = (mRow - 1) * W + mCol - 1;
			Deque<Character> Q = new ArrayDeque<>();
			for(int i = 0; i<mCol; i++) {
				Q.offerLast(memo[idx / W].pollFirst());
			}
			Character ans = Q.peekLast();
			while(!Q.isEmpty()) {
				memo[idx / W].offerFirst(Q.pollLast());
			}
			return ans;
		}
	}

	int countCharacter(char mChar) {

		return 0;
	}
}