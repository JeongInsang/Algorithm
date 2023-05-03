t = 10
for tc in range(1, t+1):
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]
    max_num = 0
    x, y = 0, 0
    temp = []

    for i in range(100):
        row, col = 0, 0
        for j in range(100):
            row += arr[i][j]
            col += arr[j][i]
            if i + j == 99:
                y += arr[i][j]
        temp.append(row), temp.append(col), temp.append(y)
        x += arr[i][i]
    temp.append(x)

    max_num = max(max_num, max(temp))
    print(f'#{tc} {max_num}')