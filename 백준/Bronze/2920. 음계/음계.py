import sys
# sys.stdin.readline()
a = [i for i in range(1, 9)]
arr = list(map(int, sys.stdin.readline().split()))

if arr == a:
    print('ascending')
elif arr == a[::-1]:
    print('descending')
else:
    print('mixed')
