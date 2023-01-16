n = int(input())

for i in range(n):
    score = list(map(int, input().split()))
    score.pop(0)
    cnt = 0
    for j in score:
        if j > sum(score) / len(score):
            cnt += 1
    answer = cnt / len(score) * 100
    print('%.3f%%' % answer)