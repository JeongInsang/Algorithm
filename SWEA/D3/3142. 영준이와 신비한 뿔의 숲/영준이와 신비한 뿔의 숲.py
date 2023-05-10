t = int(input())
for tc in range(1, t+1):
    n, m = map(int, input().split())
    a = n-m
    b = m-a
    print(f'#{tc} {b} {a}')