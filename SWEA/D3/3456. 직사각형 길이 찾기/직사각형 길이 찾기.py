t = int(input())
for tc in range(1, t + 1):
    arr = list(map(int, input().split()))
    for i in arr:
        if arr.count(i) == 1 or arr.count(i) == 3:
            print(f'#{tc} {i}')
            break