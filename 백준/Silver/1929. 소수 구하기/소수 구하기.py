import math

n, m = map(int, input().split())

for i in range(n, m+1):
    prime = True
    if i == 1:
        prime = False
    for j in range(2, int(math.sqrt(i)+1)):
        if i % j == 0:
            prime = False
            break
    if prime:
        print(i)


