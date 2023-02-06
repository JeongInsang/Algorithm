n = int(input())
score = list(map(int, input().split()))
max_val = max(score)

for i in range(len(score)):
    score[i] = score[i] / max_val * 100
print(sum(score) / n)
