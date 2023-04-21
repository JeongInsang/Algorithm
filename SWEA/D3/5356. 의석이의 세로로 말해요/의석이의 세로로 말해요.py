from collections import deque

t = int(input())
for tc in range(1, t+1):
    arr = [deque(input()) for _ in range(5)]
    answer = []

    for i in range(15):
        for j in range(5):
            if arr[j]:
                answer.append(arr[j].popleft())
            else:
                continue
    answer = ''.join(answer)
    print(f'#{tc} {answer}')