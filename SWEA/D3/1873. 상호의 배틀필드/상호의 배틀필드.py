def location(x, y):
    t = (x, y)
    if board[x][y] == '<':
        m = 2
    elif board[x][y] == '>':
        m = 0
    elif board[x][y] == '^':
        m = 3
    elif board[x][y] == 'v':
        m = 1

    return t, m


def func(c):
    global tank
    global move
    global board

    x, y = tank
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

    if c == 'S':
        dx, dy = x + directions[move][0], y + directions[move][1]
        while 0 <= dx < h and 0 <= dy < w:
            if board[dx][dy] == '*':
                board[dx][dy] = '.'
                break
            elif board[dx][dy] == '#':
                break
            dx, dy = dx + directions[move][0], dy + directions[move][1]

    elif c == 'U':
        move = 3
        board[x][y] = '^'
        dx, dy = x + directions[move][0], y + directions[move][1]
        if 0 <= dx < h and 0 <= dy < w and board[dx][dy] == '.':
            board[dx][dy] = '^'
            board[x][y] = '.'
            tank = (dx, dy)

    elif c == 'D':
        move = 1
        board[x][y] = 'v'
        dx, dy = x + directions[move][0], y + directions[move][1]
        if 0 <= dx < h and 0 <= dy < w and board[dx][dy] == '.':
            board[dx][dy] = 'v'
            board[x][y] = '.'
            tank = (dx, dy)

    elif c == 'L':
        move = 2
        board[x][y] = '<'
        dx, dy = x + directions[move][0], y + directions[move][1]
        if 0 <= dx < h and 0 <= dy < w and board[dx][dy] == '.':
            board[dx][dy] = '<'
            board[x][y] = '.'
            tank = (dx, dy)

    elif c == 'R':
        move = 0
        board[x][y] = '>'
        dx, dy = x + directions[move][0], y + directions[move][1]
        if 0 <= dx < h and 0 <= dy < w and board[dx][dy] == '.':
            board[dx][dy] = '>'
            board[x][y] = '.'
            tank = (dx, dy)


test = int(input())
for tc in range(1, test+1):
    h, w = map(int, input().split())
    board = [list(input()) for _ in range(h)]
    n = int(input())
    cmd = list(input())

    for i in range(h):
        for j in range(w):
            if board[i][j] == '<' or board[i][j] == '>' or board[i][j] == '^' or board[i][j] == 'v':
                tank, move = location(i, j)

    for c in cmd:
        func(c)

    print(f'#{tc}', end=' ')
    for k in board:
        print(''.join(k))