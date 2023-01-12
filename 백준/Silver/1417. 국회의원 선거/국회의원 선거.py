n = int(input())
m = []
answer = 0
for i in range(n):
    m.append(int(input()))
if m[0] == max(m) and m.count(max(m)) == 1:
    print(answer)

else:
    while m[0] <= max(m[1:len(m)]):
        if m[0] <= max(m):
            m[m[1:len(m)].index(max(m[1:len(m)]))+1] -= 1
            m[0] += 1
            answer += 1
    print(answer)

