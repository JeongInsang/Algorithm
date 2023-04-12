def func(x, y):
    directions = [(0, -1), (1, 0), (0, -1), (-1, 0), (1, 1), (1, -1), (-1, -1), (-1, 1)]
    a, b = x, y
    move = 0
    for _ in range(8):
        cnt = 0
        for _ in range(4):
            dx, dy = x + directions[move][0], y + directions[move][1]
            if 0 <= dx < n and 0 <= dy < n and arr[dx][dy] == 'o':
                x, y = dx, dy
                cnt += 1
            else:
                break
        if cnt == 4:
            return True
        move += 1
        x, y = a, b

    return False


t = int(input())
for tc in range(1, t+1):
    n = int(input())
    arr = [list(input()) for _ in range(n)]
    flag = False

    for i in range(n):
        for j in range(n):
            if arr[i][j] == 'o' and func(i, j):
                flag = True
                break
        if flag:
            break

    if flag:
        print('#{} YES'.format(tc))
    else:
        print('#{} NO'.format(tc))