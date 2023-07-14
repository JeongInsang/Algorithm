t = int(input())

for tc in range(1, t+1):
    l = int(input())
    
    s = input()
    s_len = int(l / 2)
    if (s[:s_len] * 2 == s):
        print(f'#{tc} Yes')
    else:
        print(f'#{tc} No')
    