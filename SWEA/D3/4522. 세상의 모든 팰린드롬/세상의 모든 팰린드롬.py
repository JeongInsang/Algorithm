def func(s):
    reverse_s = s[::-1]
    flag = False

    for i in range(len(s)):
        if s[i] == reverse_s[i] or (s[i] == '?' or reverse_s[i] == '?'):
            flag = True
        else:
            flag = False
            break
    if flag:
        return True
    return False


t = int(input())

for tc in range(1, t + 1):
    s = input()

    if func(s):
        print(f'#{tc} Exist')
    else:
        print(f'#{tc} Not exist')