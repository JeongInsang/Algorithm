n,m = list(map(int, input().split()))
answer = 0
s = []
for i in range(n):
    s.append(input())
arr = []
for j in range(m):
    arr.append(input())

for i in arr:
    if i in s:
        answer += 1
print(answer)

