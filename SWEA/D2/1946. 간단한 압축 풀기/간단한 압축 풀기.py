t = int(input())

for tc in range(1, t+1):
    n = int(input())
    chars = []
    for i in range(n):
        c, k = map(str, input().split())
        chars += ([c] * int(k))
    print(f'#{tc}')
    for i, char in enumerate(chars):
        if i == 0 or i % 10 != 9:
            print(char, end='')
        else:
            print(char)
    print()