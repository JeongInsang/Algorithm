from itertools import combinations

n, k = map(int, input().split())
nums = list(map(int, input().split()))
answer = 0

for i in range(1, n+1):
    c = combinations(nums, i)
    for j in c:
        if sum(j) == k:
            answer += 1
print(answer)


