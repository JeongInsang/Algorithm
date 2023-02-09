import sys

n, m = map(int, sys.stdin.readline().split())
listen_see = [input() for i in range(n)] + [input() for i in range(m)]
listen_see.sort()
temp = []
answer = {}

for i in listen_see:
    if i not in answer:
        answer[i] = 1
    else:
        answer[i] += 1

for key in answer.keys():
    if answer[key] == 2:
        temp.append(key)

print(len(temp))
for i in temp:
    print(i)