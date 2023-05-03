t = 10
for tc in range(1, t+1):
    n = int(input())
    target = input()
    s = input()
    t_len = len(target)
    s_len = len(s)
    answer = 0

    for start in range(s_len - t_len + 1):
        if s[start:start+t_len] == target:
            answer += 1
    print(f'#{tc} {answer}')
