t = int(input())
for tc in range(1, t + 1):
    n, m = map(int, input().split())
    arr1 = set(map(str, input().split()))
    arr2 = set(map(str, input().split()))
    answer = len(arr1 & arr2)
    print(f'#{tc} {answer}')
