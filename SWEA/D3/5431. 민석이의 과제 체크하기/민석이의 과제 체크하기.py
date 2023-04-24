t = int(input())
for tc in range(1, t+1):
    n, m = map(int, input().split())
    arr = [False] * n
    for i in list(map(int, input().split())):
        arr[i-1] = True

    print(f'#{tc}', end=' ')
    for idx in range(len(arr)):
        if not arr[idx]:
            print(idx+1, end=' ')
    print()