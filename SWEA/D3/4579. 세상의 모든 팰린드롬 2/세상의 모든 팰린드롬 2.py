def func(s):
    reverse_s = s[::-1]
    a, b = '', ''
    for i in range(len(s)):
        if s[i] == '*' or reverse_s[i] == '*':
            break
        a += s[i]
        b += reverse_s[i]
    if a == b:
        return True
    return False


t = int(input())

for tc in range(1, t + 1):
    s = input()
    if '*' in s:
        if func(s):
            print(f'#{tc} Exist')
        else:
            print(f'#{tc} Not exist')

    else:
        if s == s[::-1]:
            print(f'#{tc} Exist')
        else:
            print(f'#{tc} Not exist')