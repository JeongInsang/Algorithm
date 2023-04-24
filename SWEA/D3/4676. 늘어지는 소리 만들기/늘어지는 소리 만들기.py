from collections import deque

t = int(input())
for tc in range(1, t+1):
    s = input()
    h = int(input())
    h_idx = list(map(int, input().split()))
    arr = [deque(s[i]) for i in range(len(s))]

    for idx in h_idx:
        if idx == 0:
            arr[0].appendleft('-')
        elif idx <= len(s):
            arr[idx-1].append('-')
        else:
            arr[-1].append('-')
            
    answer = ''
    for i in arr:
        for j in i:
            answer += j

    print(f'#{tc} {answer}')