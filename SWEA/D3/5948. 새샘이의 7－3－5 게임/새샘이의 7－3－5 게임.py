from itertools import combinations
t = int(input())

for tc in range(1, t+1):
    answer = []
    for i in combinations(list(map(int, input().split())), 3):
        answer.append(sum(i))
    print(f'#{tc} {sorted(set(answer), reverse=True)[4]}')