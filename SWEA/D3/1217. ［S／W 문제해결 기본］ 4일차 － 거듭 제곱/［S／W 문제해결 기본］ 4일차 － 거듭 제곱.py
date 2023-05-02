def func(n, m, a):
    if m <= 1:
        return n
    return func(n*a, m-1, a)


t = 10
for tc in range(1, t+1):
    n = int(input())
    n, m = map(int, input().split())
    a = n

    print(f'#{tc} {func(n, m, a)}')