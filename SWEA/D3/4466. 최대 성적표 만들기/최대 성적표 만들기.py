t = int(input())

for tc in range(1, t + 1):
    n, k = map(int, input().split())
    score = list(map(int, input().split()))
    score.sort(reverse=True)

    answer = 0
    for s in range(k):
        answer += score[s]

    print(f'#{tc} {answer}')