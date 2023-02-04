from collections import deque
import sys

queue = deque()
answer = deque()
n = int(sys.stdin.readline())
for _ in range(n):
    cmd = list(map(str, sys.stdin.readline().split()))
    if cmd[0] == 'push':
        queue.append(cmd[1])
    elif cmd[0] == 'pop':
        if queue:
            answer.append((queue.popleft()))
        else:
            answer.append(-1)
    elif cmd[0] == 'size':
        answer.append(len(queue))
    elif cmd[0] == 'empty':
        if queue:
            answer.append(0)
        else:
            answer.append(1)
    elif cmd[0] == 'front':
        if queue:
            answer.append(queue[0])
        else:
            answer.append(-1)
    elif cmd[0] == 'back':
        if queue:
            answer.append(queue[-1])
        else:
            answer.append(-1)

for i in answer:
    print(i)