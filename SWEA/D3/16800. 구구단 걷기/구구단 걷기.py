import math
tc = int(input())
x, y = 1, 1

for t in range(1, tc+1):
    n = int(input())
    for k in range(1, int(math.sqrt(n))+1):
        if n % k == 0:
            i = k
    j = int(n / i)

    print('#{} {}'.format(t, (abs(x-i) + abs(y-j))))