import sys

arr = list(sys.stdin.readline().rstrip())
arr2 = []

for i in range(int(sys.stdin.readline())):
    cmd = list(sys.stdin.readline().split())

    if cmd[0] == 'L':
        if arr:
            arr2.append(arr.pop())

    elif cmd[0] == 'D':
        if arr2:
            arr.append(arr2.pop())

    elif cmd[0] == 'B':
        if arr:
            arr.pop()

    elif cmd[0] == 'P':
        arr.append(cmd[1])

arr.extend(reversed(arr2))
print(''.join(arr))
