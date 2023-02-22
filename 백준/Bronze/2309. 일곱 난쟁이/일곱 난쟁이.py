from itertools import combinations

dwarf = []

for _ in range(9):
    dwarf.append(int(input()))

for i in combinations(dwarf, 7):
    if sum(i) == 100:
        answer = i
        break
answer = list(answer)
answer.sort()
for j in answer:
    print(j)