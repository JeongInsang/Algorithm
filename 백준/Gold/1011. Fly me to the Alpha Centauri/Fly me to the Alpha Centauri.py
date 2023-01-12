tc = int(input())

for i in range(tc):
    x,y = map(int, input().split())
    cnt = 0
    move = 1
    move_sum = 0

    while move_sum < y-x:
        cnt += 1
        move_sum += move
        if cnt % 2 == 0:
            move += 1
    print(cnt)
