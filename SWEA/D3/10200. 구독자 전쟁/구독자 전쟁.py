t = int(input())

for tc in range(1, t + 1):
    n, a, b = map(int, input().split())

    if a + b <= n:
        print(f'#{tc} {min(a, b)} {0}')
    else:
        print(f'#{tc} {min(a, b)} {max(a,b) + min(a,b) - n}')
