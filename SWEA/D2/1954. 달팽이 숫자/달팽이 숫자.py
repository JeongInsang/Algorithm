t = int(input())

for tc in range(1, t+1):
    n = int(input())
    arr = [[0 for _ in range(n)] for _ in range(n)]
    arr[0][0] = 1
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    move = 0
    x, y = 0, 0
    num = 2
    while num <= n*n:
        dx, dy = x + directions[move][0], y + directions[move][1]
        if 0 <= dx < n and 0 <= dy < n and arr[dx][dy] == 0:
            arr[dx][dy] = num
            x, y = dx, dy
            num += 1
        else:
            move = (move + 1) % 4
    print(f'#{tc}')
    for i in arr:
        print(*i)
