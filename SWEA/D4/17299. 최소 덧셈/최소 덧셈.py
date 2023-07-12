t = int(input())

for tc in range(1, t+1):
    num = list(input())
    ans = 99999999
    for n in range(len(num)-1):
        temp = int(''.join(num[:n+1])) + int(''.join(num[n+1:]))
        if temp < ans:
            ans = temp
    print(f'#{tc} {ans}')