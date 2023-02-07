import sys
# sys.stdin.readline()

a, b = map(str, sys.stdin.readline().split())

a, b = int(a[::-1]), int(b[::-1])
if a > b:
    print(a)
else:
    print(b)