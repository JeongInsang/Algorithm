t = int(input())
for tc in range(1, t+1):
    score = list(map(int, input().split()))
    for i in range(5):
        if score[i] < 40:
            score[i] = 40
    answer = int(sum(score) / 5)
    print(f'#{tc} {answer}')