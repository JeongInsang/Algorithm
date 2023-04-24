def prime(a, b):
    arr = [True for _ in range(b+1)]
    arr[0], arr[1] = False, False
    for i in range(2, int(b ** 0.5) + 1):
        if arr[i] == True:
            for j in range(i+i, b+1, i):
                arr[j] = False
    prime_list = [i for i in range(a, b+1) if arr[i] == True]
    return prime_list


t = int(input())
for tc in range(1, t+1):
    d, a, b = map(int, input().split())
    prime_list = prime(a, b)
    answer = 0

    for i in prime_list:
        for j in str(i):
            if str(d) == j:
                answer += 1
                break
    print(f'#{tc} {answer}')