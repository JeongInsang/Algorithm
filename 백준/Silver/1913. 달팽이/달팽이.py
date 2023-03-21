n = int(input())
num = int(input())
answer = (0, 0)

directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
x, y = n // 2, n // 2
arr = [[0 for _ in range(n)] for _ in range(n)]
move, move_n = 3, 1


def in_range(x, y):
    return 0 <= x < n and 0 <= y < n


i = 1
while in_range(x, y):
    for _ in range(move_n):
        arr[x][y] = i
        if i == num:
            answer = (x, y)
        i += 1

        x, y = x + directions[move][0], y + directions[move][1]
        if not in_range(x, y):
            break

    move = (move + 1) % 4
    if move == 1 or move == 3:
        move_n += 1

for i in arr:
    print(*i)
print(answer[0]+1, answer[1]+1)
