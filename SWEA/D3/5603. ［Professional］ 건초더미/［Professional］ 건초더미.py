t = int(input())
for tc in range(1, t+1):
    n = int(input())
    arr = [int(input()) for _ in range(n)]
    answer = 0
    arr_avg = int(sum(arr) / n)

    for i in range(n):
        answer += abs(arr_avg - arr[i])
    print(f'#{tc} {int(answer/2)}')