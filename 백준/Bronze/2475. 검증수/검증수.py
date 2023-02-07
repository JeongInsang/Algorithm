import sys

arr = list(map(int, sys.stdin.readline().split()))
for i in range(len(arr)):
    arr[i] *= arr[i]
print(sum(arr) % 10)