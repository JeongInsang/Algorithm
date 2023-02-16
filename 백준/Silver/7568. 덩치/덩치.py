t = int(input())
people = []
rank = 1
for _ in range(t):
    people.append(list(map(int, input().split())))

for i in people:
    for j in people:
        if i[0] != j[0] and i[1] != j[1]:
            if i[0] < j[0] and i[1] < j[1]:
                rank += 1
    print(rank)    
    rank = 1