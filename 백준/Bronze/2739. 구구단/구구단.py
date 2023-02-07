import sys
# sys.stdin.readline()

n = int(sys.stdin.readline())
for i in range(1,10):
    print('{} * {} = {}'.format(n, i, n*i))