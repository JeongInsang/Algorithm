t = int(input())
for tc in range(1, t+1):
    memory = input()
    flag = '0'
    answer = 0

    for i in range(len(memory)):
        if memory[i] != flag:
            answer += 1
            flag = memory[i]

    print(f'#{tc} {answer}')