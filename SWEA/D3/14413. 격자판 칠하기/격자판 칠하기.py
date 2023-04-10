def dec(x, y):
    move = 0
    for _ in range(4):
        dx, dy = x + directions[move][0], y + directions[move][1]
        if 0 <= dx < n and 0 <= dy < m:
            if arr[x][y] != '?' and arr[x][y] == arr[dx][dy]:
                return False

            elif arr[dx][dy] == '?' and arr[x][y] == '#':
                arr[dx][dy] = '.'

            elif arr[dx][dy] == '?' and arr[x][y] == '.':
                arr[dx][dy] = '#'

        move = (move + 1) % 4


tc = int(input())
directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
for t in range(1, tc+1):
    n, m = map(int, input().split())
    arr = [list(input()) for _ in range(n)]

    for i in range(n):
        flag = True
        for j in range(m):
            if dec(i, j) == False:
                flag = False
                break
        if flag == False:
            print('#{} impossible'.format(t))
            break
    if flag:
        print('#{} possible'.format(t))