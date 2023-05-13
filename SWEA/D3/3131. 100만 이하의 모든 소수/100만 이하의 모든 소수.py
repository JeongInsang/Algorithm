n = 1000000
arr = [False, False] + [True] * 999998

for i in range(2, int(n**0.5)+1):
    if arr[i]:
        for j in range(i + i, n, i):
            arr[j] = False

for idx, val in enumerate(arr):
    if val:
        print(idx, end=' ')