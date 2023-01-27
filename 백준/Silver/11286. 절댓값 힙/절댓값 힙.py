import heapq
import sys

queue = []
n = int(input())

for i in range(n):
    # num = int(input())
    num = int(sys.stdin.readline())

    if num == 0:
        if len(queue) == 0:
            print(0)
        else:
            print(heapq.heappop(queue)[1])
    else:
        heapq.heappush(queue, (abs(num), num))