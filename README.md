# 📚 Algorithm & Data Structure Study Notes

알고리즘 및 자료구조 학습 내용을 정리한 문서입니다.

## 목차
1. [시간/공간 복잡도](#1-시간공간-복잡도)
2. [실수 표현 (IEEE 754)](#2-실수-표현-ieee-754)
3. [함수 인자와 STL](#3-함수-인자와-stl)
4. [입출력 및 문자열 처리](#4-입출력-및-문자열-처리)
5. [자료구조 (Data Structures)](#5-자료구조-data-structures)
6. [알고리즘 (Algorithms)](#6-알고리즘-algorithms)
7. [기타 (ASCII)](#7-기타-ascii)

---

## 1. 시간/공간 복잡도

### 시간 복잡도 (Time Complexity)
> 입력의 크기와 문제를 해결하는데 걸리는 시간의 상관관계

![시간복잡도 그래프](https://github.com/user-attachments/assets/23bcb040-8232-404f-8c58-d07570d2b12d)

* **연산 속도:** 컴퓨터는 1초 동안 약 **3억~5억 개**의 연산을 수행 가능.
* **제한 시간:** 제한 시간이 1초라면, 3억~5억 번의 연산 내에 결과를 도출해야 함.
* **이분 탐색:** 1~100 범위에서 업다운(Up-down)으로 수를 찾을 때, 절반씩 줄여가며 찾는 연산은 **O(log N)**.

![로그 시간 복잡도](https://github.com/user-attachments/assets/c7adf7ba-0d8b-444d-bb04-7edd33677204)

### 공간 복잡도 (Space Complexity)
> 입력의 크기와 문제를 해결하는데 필요한 공간의 상관관계

* **메모리 제한:** 512MB ≈ 1.2억 개의 `int` 변수 저장 가능.
* **주의:** 메모리 제한이 512MB인데 크기가 5억인 `int` 배열을 선언하는 것은 불가능.

---

## 2. 실수 표현 (IEEE 754)

![실수 표현](https://github.com/user-attachments/assets/0b4ec776-d590-436b-b5d8-497ddbe39a2b)

1. **오차 발생:** 실수의 저장/연산 과정에서 반드시 오차가 발생함.
    * `float`: 유효숫자 6자리 (오차가 큼, 소수 자료형 필요 시 가급적 `double` 사용)
    * `double`: 유효숫자 15자리
    * *Tip:* 문제에 $10^{-6}$ 오차 허용 등의 문구가 없다면 대부분 정수만으로 풀이 가능.
2. **자료형 주의:** `double`에 `long long` 범위의 정수를 담으면 안 됨 (`double`의 유효숫자가 더 적음).
3. **실수 비교:** `==`로 비교 금지. 오차 보정을 위해 아주 작은 값을 이용해 비교해야 함.
    ```cpp
    // 두 실수가 같은지 비교하는 방법
    if (abs(a - b) < 1e-12) { ... }
    ```

---

## 3. 함수 인자와 STL

### 값 전달 vs 참조 전달
* **값에 의한 전달 (Call by Value):** 변수, 구조체, STL 등을 그대로 넘기면 **값이 복사**됨. 함수 내에서 변경해도 원본은 변하지 않음.
    * 배열을 넘기는 경우: 주소값(포인터)이 넘어가므로 원본 변경 가능.
* **STL 전달 시 주의:**
    * 벡터 등을 그냥 넘기면 복사 비용 발생 → 시간 복잡도 **O(N)**.
    
    ![STL 복사](https://github.com/user-attachments/assets/634241ec-bae6-4390-b37c-d4dfbe78896b)

    * **참조자(`&`) 사용:** 주소 정보만 전달하므로 복사 비용 없음 → **O(1)**.
    
    ![참조자 사용](https://github.com/user-attachments/assets/a979be2d-814e-45e6-a518-3d2346886b76)

---

## 4. 입출력 및 문자열 처리

### 입출력 최적화 (Fast I/O)
```cpp
ios::sync_with_stdio(false); // C stream(scanf/printf)과 C++ stream(cin/cout) 동기화 해제
cin.tie(nullptr);            // 입력 전 출력 버퍼 비움(flush) 방지
```

---

## 5. 자료구조 (Data Structures)

### 0x01 배열 (Array)
* **특징:** 메모리 상에 원소가 연속적으로 배치됨.
    * k번째 원소 확인: **O(1)** (메모리 주소 연산 가능)
    * 추가/제거 (끝): **O(1)**
    * 추가/제거 (임의 위치): **O(N)** (나머지 원소들을 밀어내는 연산 필요)
* **초기화 및 유틸리티:**
    * `std::fill(Start, End, Value)`: 초기화 시 권장 (`memset`은 0, -1 외의 값 초기화 시 오작동).
    * `std::copy(Start, End, Target)`: 배열 복사.
    * `*max_element(begin, end)`: 최댓값 포인터 반환.
* **주의:** 전역 변수는 0으로 자동 초기화되지만, 지역 변수는 반드시 초기화 필요.

### 0x02 벡터 (Vector)
* **특징:** 크기가 동적으로 변하는 배열.
    * `push_back`, `pop_back`: **O(1)**
    * `insert`, `erase`: **O(N)** (중간 삽입/삭제 시 밀어내기 발생)
* **Range-based for loop:**
    ```cpp
    for(int &e : v1) { // &를 써야 원본 값 변경 가능
        e = 10; 
    }
    ```
* **주의:** `vector.size()`는 `unsigned int`를 반환. 빈 벡터(`size=0`)에서 값을 빼면 언더플로우 발생하여 거대한 양수가 됨.

![벡터 이미지](https://github.com/user-attachments/assets/f1ba1ddc-6469-4234-b8ee-1c389164c6be)

### 0x03 연결 리스트 (Linked List)
* **특징:** 원소들이 주소로 연결됨 (불연속 메모리).
    * 임의 원소 접근: **O(N)** (처음부터 따라가야 함)
    * 임의 위치 추가/제거: **O(1)** (단, 해당 위치의 주소(iterator)를 알고 있을 때)
* **종류:** 단일, 이중(`std::list`), 원형 연결 리스트.
* **STL 사용법:**
    ```cpp
    list<int>::iterator t = L.begin();
    L.insert(t, 6); // t 앞에 6 삽입
    L.erase(t);     // t 삭제 후 다음 위치 반환
    ```

![리스트 삽입](https://github.com/user-attachments/assets/d0ed83a3-4323-4c94-aa5d-bf5ed009d69c)
![리스트 삭제](https://github.com/user-attachments/assets/cae8048e-dd7a-4bcf-af1a-cc3631a91bb5)

### 0x04 스택 (Stack)
* **특징:** 후입선출(FILO). 한쪽 끝에서만 작업 가능.
* **연산:** `push`, `pop`, `top` 모두 **O(1)**.
* **활용:** 수식의 괄호 쌍 검사 등.
* **주의:** 비어있을 때 `top`, `pop` 호출 시 런타임 에러 발생.

![스택](https://github.com/user-attachments/assets/47c8615a-c243-4cdf-9ee9-562ef63f178e)

### 0x05 큐 (Queue)
* **특징:** 선입선출(FIFO). 뒤에서 넣고 앞에서 뺌.
* **연산:** `push`, `pop`, `front`, `back` 모두 **O(1)**.
* **구현:** 배열로 구현 시 공간 효율을 위해 **원형 큐(Circular Queue)** 사용.

![큐](https://github.com/user-attachments/assets/77232d52-3841-4ec2-84e2-9bad75540ef3)

### 0x06 덱 (Deque)
* **특징:** Double Ended Queue. 양쪽 끝에서 삽입/삭제 가능.
* **연산:** `push_front`, `push_back`, `pop_front`, `pop_back` 모두 **O(1)**.
* **장점:** 스택과 큐의 기능을 모두 가짐. 벡터와 달리 인덱스 접근이 가능하면서도 메모리에 불연속적으로 할당됨.

![덱](https://github.com/user-attachments/assets/acfdfe51-7edc-4a86-929f-54cfbe5bb0be)

### 0x07 스택의 활용 (괄호 쌍)
* **문제:** 문자열 내의 괄호 `(`, `{`, `[` 가 올바르게 닫혔는지 확인.
* **로직:**
    1. 여는 괄호면 `push`.
    2. 닫는 괄호면 `top`과 짝이 맞는지 확인 후 `pop`.
    3. 문자열 끝났는데 스택이 안 비었거나, 비었는데 `pop` 시도하면 오류.

---

## 6. 알고리즘 (Algorithms)

### 0x08 BFS (Breadth First Search)
* **개념:** 너비 우선 탐색. 시작점에서 가까운 곳부터 방문.
* **자료구조:** `Queue<pair<int, int>>`
* **핵심 로직:**
    ```cpp
    queue.push(start);
    vis[start] = 1; // 1. 시작점 방문 표시
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++) {
            // 상하좌우 탐색
            if(범위초과 || 이미방문) continue;
            vis[nx][ny] = 1; // 2. 큐에 넣을 때 방문 표시 (중복 방지)
            q.push({nx, ny});
        }
    }
    ```

![BFS](https://github.com/user-attachments/assets/df2f402e-d820-4d09-9a1e-780cca3a631b)

### 0x09 DFS (Depth First Search)
* **개념:** 깊이 우선 탐색.
* **구현:** **Stack** 또는 **재귀(Recursion)** 사용.
* **특징:** BFS와 달리 최단 거리를 보장하지 않음. 그래프/트리 순회에 주로 사용.

### 0x0A 재귀 (Recursion)
* **개념:** 함수가 자기 자신을 호출. 수학적 귀납법과 유사.
* **필수 조건:**
    1. **Base Condition:** 재귀 없이 종료되는 조건이 반드시 있어야 함.
    2. **수렴:** 모든 입력은 결국 Base Condition에 도달해야 함.
* **주의:** 깊어질수록 스택 메모리 누적 (Stack Overflow 주의).

![재귀](https://github.com/user-attachments/assets/c5bccc8b-6139-4316-b4e2-63b99f17678d)

### 0x0B 백트래킹 (Backtracking)
* **개념:** 가능한 모든 경우를 탐색하되, 불가능한 경우(가지치기) 되돌아가는 방식.
* **구현:** 재귀 + `isused` 배열(방문처리) 활용.
    ```cpp
    void func(int k) {
        if(base_condition) { return; }
        for(int i=1; i<=n; i++) {
            if(!isused[i]) {
                isused[i] = 1; // 상태 변경
                func(k+1);     // 다음 단계 진입
                isused[i] = 0; // 원상 복구 (Backtracking)
            }
        }
    }
    ```
* **순열:** C++ `next_permutation` 활용 시 사전 순 순열 생성 가능 (do-while 구조 권장).

![백트래킹](https://github.com/user-attachments/assets/7e214a32-460d-49a5-b65f-eb246d9d8c2e)

---

## 7. 기타 (ASCII Code)

* **주요 값:**
    * `'a'` = 97 (`'z'` = 122)
    * `'A'` = 65 (`'Z'` = 90)
    * `'0'` = 48
* **활용 팁:**
    * 소문자 인덱싱(0~25): `char - 97` 또는 `char - 'a'`
    * 문자형 숫자를 정수로: `char - '0'` (예: `'5' - '0' = 5`)
    * 문자열 → 정수 변환: `atoi(str.c_str())` 또는 `stoi(str)`
