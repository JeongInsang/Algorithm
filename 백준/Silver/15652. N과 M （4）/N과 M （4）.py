from itertools import combinations_with_replacement as cwr
n, m = map(int, input().split())
n = [i for i in range(1, n+1)]

for i in cwr(n, m):
    print(*i)