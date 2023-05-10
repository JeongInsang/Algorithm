t = 10
for tc in range(1, t+1):
    word_len = int(input())
    word = list(input().split())
    cmd_len = int(input())
    cmd = list(input().split())

    for idx, val in enumerate(cmd):
        if val == 'I':
            for i in range(int(cmd[idx+2])):
                word.insert(int(cmd[idx+1]) + i, cmd[idx+3+i])
        elif val == 'D':
            del word[int(cmd[idx+1]): int(cmd[idx+1]) + int(cmd[idx+2])]
        elif val == 'A':
            for j in cmd[idx+2: int(cmd[idx+1]) + idx+2]:
                word.append(j)

    print(f'#{tc}', end=' ')
    for ans in range(10):
        print(word[ans], end=' ')
    print()