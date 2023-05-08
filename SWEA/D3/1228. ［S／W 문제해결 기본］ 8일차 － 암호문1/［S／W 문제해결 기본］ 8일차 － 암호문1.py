t = 10
for tc in range(1, t+1):
    word_len = int(input())
    word = list(map(int, input().split()))
    cmd_len = int(input())
    cmd = input().split()

    for idx, val in enumerate(cmd):
        if val == 'I':
            for i in range(idx+2 + int(cmd[idx+2]), idx+2, -1):
                word.insert(int(cmd[idx+1]), cmd[i])

    print(f'#{tc}', end=' ')
    for i in range(10):
        print(word[i], end=' ')
    print()

