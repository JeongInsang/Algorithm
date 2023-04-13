t = int(input())

for tc in range(1, t + 1):
    n = int(input())
    line = [list(map(int, input().split())) for _ in range(n)]
    answer = 0
    for i in range(n):
        x1, y1 = line[i][0], line[i][1]
        for j in range(i+1, n):
            x2, y2 = line[j][0], line[j][1]
            if (x1 < x2 and y1 > y2) or (x1 > x2 and y1 < y2):
                answer += 1
    print(f'#{tc} {answer}')
