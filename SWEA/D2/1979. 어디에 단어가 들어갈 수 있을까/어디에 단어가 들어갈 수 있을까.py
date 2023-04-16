t = int(input())

for tc in range(1, t+1):
    n, m = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]
    answer = 0
    for i in range(n):
        cnt = 0
        for j in range(n):
            if arr[i][j] == 1:
                cnt += 1
            else:
                if cnt == m:
                    answer += 1
                cnt = 0
        if cnt == m:
            answer += 1

        cnt = 0
        for k in range(n):
            if arr[k][i] == 1:
                cnt += 1
            else:
                if cnt == m:
                    answer += 1
                cnt = 0
        if cnt == m:
            answer += 1
    print(f'#{tc} {answer}')




