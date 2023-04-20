from itertools import combinations

t = int(input())

for tc in range(1, t+1):
    nums = list(map(int, input().split()))
    answer = []

    for i in combinations(nums, 3):
        answer.append(sum(i))
    answer = list(set(answer))
    answer.sort()
    print(f'#{tc} {answer[-5]}')