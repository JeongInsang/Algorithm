t = int(input())

for tc in range(1, t+1):
    n = int(input())
    bus = [list(map(int, input().split())) for _ in range(n)]
    p = int(input())
    answer = []
    for _ in range(p):
        bus_num = int(input())
        cnt = 0
        for a, b in bus:
            for i in range(a, b+1):
                if bus_num == i:
                    cnt += 1
        answer.append(cnt)
    print(f'#{tc}', end=' ')
    for i in answer:
        print(i, end=' ')
    print()