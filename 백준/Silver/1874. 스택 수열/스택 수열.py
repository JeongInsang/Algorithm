#백준 - 스택 수열

n = int(input())
stack =[]
cnt = 1
answer = []
flag = 1

for i in range(n):
    num = int(input())
    while cnt <= num:
        stack.append(cnt)
        cnt += 1
        answer.append('+')
    if stack[-1] == num:
        answer.append('-')
        stack.pop()
    else:
        print('NO')
        flag = 0
        break
    
if flag == 1:
    for j in answer:
        print(j)