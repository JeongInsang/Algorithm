# SW Expert Academy D3 체스판 위의 룩 배치(보류)

t = int(input())
answer = []
for tc in range(1, t + 1):
    cnt = 0
    a, b, c, d = map(int, input().split())
    x = [i for i in range(a, b+1)]
    y = [i for i in range(c, d+1)]

    for i in x:
        if i in y:
            cnt += 1
    if cnt > 0:
        cnt -= 1
    answer.append('#{} {}'.format(tc, cnt))

for i in answer:
    print(i)
