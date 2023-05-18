t = int(input())
for tc in range(1, t+1):
    n = int(input())
    arr = [[0 for _ in range(n)] for _ in range(n)]
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    x, y = 0, 0
    move = 0
    i = 1
    arr[x][y] = i

    while i < n**2:
        dx, dy = x + directions[move][0], y + directions[move][1]
        if 0 <= dx < n and 0 <= dy < n and arr[dx][dy] == 0:
            i += 1
            arr[dx][dy] = i
            x, y = dx, dy
        else:
            move = (move + 1) % 4
    print(f'#{tc}')
    for j in arr:
        print(*j)