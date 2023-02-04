from itertools import product
n, m = map(int, input().split())
n = [i for i in range(1, n+1)]

for i in product(n, repeat = m):
    print(*i)