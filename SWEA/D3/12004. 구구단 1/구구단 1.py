t = int(input())

for tc in range(1, t+1):
    n = int(input())
    flag = False

    for i in range(1, 10):
        for j in range(1, 10):
            if i * j == n:
                flag = True

    if flag:
        print(f'#{tc} Yes')
    else:
        print(f'#{tc} No')
