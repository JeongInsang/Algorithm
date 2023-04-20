def prime_list(n):
    arr = [True] * n

    m = int(n ** 0.5)
    for i in range(2, m+1):
        if arr[i] == True:
            for j in range(i+i, n, i):
                arr[j] = False
    return [i for i in range(2, n) if arr[i]]


t = int(input())

for tc in range(1, t+1):
    n = int(input())
    arr = prime_list(n)
    cnt = 0
    
    for i in range(len(arr)):
        for j in range(i, len(arr)):
            for k in range(j, len(arr)):
                if arr[i] + arr[j] + arr[k] == n:
                    cnt += 1
    print(f'#{tc} {cnt}')