from itertools import combinations

t = int(input())
for tc in range(1, t+1):
    n, l = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]
    answer = 0

    for i in range(1, n+1):
        for j in combinations(arr, i):
            k_sum = 0
            t_sum = 0
            for k in range(len(j)):
                k_sum += j[k][1]
                t_sum += j[k][0]

            if k_sum <= l:
                answer = max(answer, t_sum)
    print(f'#{tc} {answer}')