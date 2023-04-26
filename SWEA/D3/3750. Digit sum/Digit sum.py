def func(n):
    answer = 0
    for i in n:
        answer += int(i)
    if answer < 10:
        return answer
    else:
        return func(str(answer))


ans = []
t = int(input())
for tc in range(1, t + 1):
    n = input()
    ans.append((tc, func(n)))

for i in ans:
    print(f'#{i[0]} {i[1]}')