package B형기출.계산게임;

import java.util.*;

class UserSolution {

    static final int MID = 100000;
    static final int MAX = 200005;

    int joker;
    int leftidx, rightidx;   // 유효 구간: [leftidx, rightidx)
    int[] nums;

    Deque<Integer>[][] bucket;
    // bucket[j][r] = 조커값이 j일 때, 결과가 r인 4장 구간의 시작 인덱스들
    // 왼쪽 -> 오른쪽 순서 유지

    void init(int mJoker, int mNumbers[]) {
        joker = mJoker;

        nums = new int[MAX];
        leftidx = MID;
        rightidx = MID;

        bucket = new ArrayDeque[31][20];
        for (int j = 1; j <= 30; j++) {
            for (int r = 0; r < 20; r++) {
                bucket[j][r] = new ArrayDeque<>();
            }
        }

        // 초기 5장 배치
        for (int i = 0; i < 5; i++) {
            nums[rightidx++] = mNumbers[i];
        }

        // 초기 윈도우 2개
        registerWindow(leftidx, false);
        registerWindow(leftidx + 1, false);
    }

    void putCards(int mDir, int mNumbers[]) {
        if (mDir == 0) {
            // 왼쪽에 붙임
            // 최종 순서가 mNumbers[0],1,2,3,4,... 가 되도록 역순 삽입
            for (int i = 4; i >= 0; i--) {
                nums[--leftidx] = mNumbers[i];
            }

            // 새로 생긴 4장 구간 시작점은 leftidx ~ leftidx+4
            // addFirst를 쓸 것이므로, 실제 왼->오 순서를 맞추려면 역순으로 등록
            for (int s = leftidx + 4; s >= leftidx; s--) {
                registerWindow(s, true);
            }
        } else {
            // 오른쪽에 붙임
            int oldRight = rightidx;

            for (int i = 0; i < 5; i++) {
                nums[rightidx++] = mNumbers[i];
            }

            // 새로 생긴 4장 구간 시작점은 oldRight-3 ~ oldRight+1
            for (int s = oldRight - 3; s <= oldRight + 1; s++) {
                registerWindow(s, false);
            }
        }
    }

    int findNumber(int mNum, int mNth, int ret[]) {
        Deque<Integer> dq = bucket[joker][mNum];

        if (dq.size() < mNth) {
            return 0;
        }

        int cnt = 0;
        int start = -1;

        for (int idx : dq) {
            cnt++;
            if (cnt == mNth) {
                start = idx;
                break;
            }
        }

        if (start == -1) {
            return 0;
        }

        ret[0] = nums[start];
        ret[1] = nums[start + 1];
        ret[2] = nums[start + 2];
        ret[3] = nums[start + 3];

        return 1;
    }

    void changeJoker(int mValue) {
        joker = mValue;
    }

    // ---------------- helper ----------------

    int cardValue(int x, int jokerValue) {
        return (x == -1) ? jokerValue : x;
    }

    // 지금은 "4장의 합 % 20" 기준
    // 문제 원문 계산식이 다르면 여기만 바꾸면 됨
    int calcResult(int start, int jokerValue) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += cardValue(nums[start + i], jokerValue);
        }
        return sum % 20;
    }

    void registerWindow(int start, boolean toFront) {
        for (int j = 1; j <= 30; j++) {
            int result = calcResult(start, j);
            if (toFront) {
                bucket[j][result].addFirst(start);
            } else {
                bucket[j][result].addLast(start);
            }
        }
    }
}