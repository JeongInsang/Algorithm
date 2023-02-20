t = int(input())

for tc in range(1, t+1):
    n, d = map(int, input().split())
    answer = 0
    while n > 0:
        n -= ((2*d) + 1)
        answer += 1
    print('#{} {}'.format(tc, answer))