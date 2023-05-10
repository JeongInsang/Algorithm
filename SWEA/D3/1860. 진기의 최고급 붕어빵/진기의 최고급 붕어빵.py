t = int(input())
for tc in range(1, t+1):
    n, m, k = map(int, input().split())
    arr = list(map(int, input().split()))
    arr.sort()
    answer = 'Possible'

    for i in range(n):
        fish = (arr[i] // m) * k - (i+1)
        if fish < 0:
            answer = 'Impossible'
            break
    
    print(f'#{tc} {answer}')