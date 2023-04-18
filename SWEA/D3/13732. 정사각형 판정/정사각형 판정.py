t = int(input())

for tc in range(1, t+1):
    n = int(input())
    arr = [list(input()) for _ in range(n)]
    temp = []
    flag = True
    max_x, max_y = -1, -1
    min_x, min_y = 20, 20
    for i in range(n):
        for j in range(n):
            if arr[i][j] == '#':
                max_x, max_y = max(max_x, i), max(max_y, j)
                min_x, min_y = min(min_x, i), min(min_y, j)

    row = max_x - min_x
    col = max_y - min_y
    if row == col:
        for i in range(min_x, max_x + 1):
            for j in range(min_y, max_y + 1):
                if arr[i][j] != '#':
                    flag = False
    else:
        flag = False

    if flag:
        print(f'#{tc} yes')
    else:
        print(f'#{tc} no')
