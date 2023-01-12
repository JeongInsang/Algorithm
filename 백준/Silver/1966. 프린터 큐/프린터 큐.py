from collections import deque

tc = int(input())
for i in range(tc):
    cnt = 1
    n, m = map(int, input().split())
    point = deque(list(map(int, input().split())))
    idex = [i for i in range(len(point))]
    idex[m] = 'target'

    while 1:
        if point[0] == max(point):
            if idex[0] == 'target':
                break
            else:
                point.popleft()
                idex.pop(0)
                cnt += 1
        else:
            point.append(point.popleft())
            idex.append(idex.pop(0))
    print(cnt)