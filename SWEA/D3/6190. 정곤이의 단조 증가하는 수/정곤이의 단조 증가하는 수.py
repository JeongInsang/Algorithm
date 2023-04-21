def func(n):
    n = str(n)
    if len(n) == 1:
        return False
    for i in range(1, len(n)):
        if int(n[i]) < int(n[i-1]):
            return False
    return True


t = int(input())
for tc in range(1, t+1):
    n = int(input())
    arr = list(map(int, input().split()))

    max_num = 0
    Flag = False
    for i in range(n):
        for j in range(i+1, n):
            num = arr[i] * arr[j]
            if func(num):
                Flag = True
                max_n = num
                max_num = max(max_num, max_n)
    if Flag:
        print(f'#{tc} {max_num}')
    else:
        print(f'#{tc} -1')