from itertools import permutations

n, k = map(int, input().split())
kit = list(map(int, input().split()))
answer = 0

for i in permutations(kit, n):
    weigth = 500
    for j in i:
        weigth += j - k
        if weigth < 500:
            break
    else:
        answer += 1
print(answer)