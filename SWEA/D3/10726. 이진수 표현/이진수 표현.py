t = int(input())
for tc in range(1, t + 1):
    n, m = map(int, input().split())
    binary = str(format(m, 'b'))
    flag = True
    if len(binary) >= n:
        for i in binary[len(binary) - n:]:
            if i == '0':
                flag = False
                break
    else:
        flag = False
    if flag:
        print(f'#{tc} ON')
    else:
        print(f'#{tc} OFF')