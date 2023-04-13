t = int(input())

for tc in range(1, t + 1):
    s = list(input())
    new = s[::-1]
    for i in range(len(new)):
        if new[i] == 'b':
            new[i] = 'd'
        elif new[i] == 'd':
            new[i] = 'b'
        elif new[i] == 'p':
            new[i] = 'q'
        else:
            new[i] = 'p'
    new = ''.join(new)
    print(f'#{tc} {new}')