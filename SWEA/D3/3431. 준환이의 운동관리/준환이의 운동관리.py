t = int(input())
for tc in range(1, t+1):
    l, u, x = map(int, input().split())

    if l > x:
        print(f'#{tc} {l-x}')
    elif l <= x <= u:
        print(f'#{tc} {0}')
    else:
        print(f'#{tc} {-1}')