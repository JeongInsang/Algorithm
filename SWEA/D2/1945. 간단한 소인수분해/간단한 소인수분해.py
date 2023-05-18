t = int(input())
for tc in range(1, t+1):
    n = int(input())
    prime = [0] * 5

    while n != 1:
        if n % 2 == 0:
            n /= 2
            prime[0] += 1
        elif n % 3 == 0:
            n /= 3
            prime[1] += 1
        elif n % 5 == 0:
            n /= 5
            prime[2] += 1
        elif n % 7 == 0:
            n /= 7
            prime[3] += 1
        elif n % 11 == 0:
            n /= 11
            prime[4] += 1
    print(f'#{tc}', end=' ')
    print(*prime)