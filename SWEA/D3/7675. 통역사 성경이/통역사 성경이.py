def check(s):
    s = s.rstrip('!.?')
    return s.isalpha() and s.istitle()
  
  
T = int(input())
for t in range(1, T + 1):
    n = int(input())
    x = 0
    cnt = [0] * n
    while x < n:
        s = input().split()
        for ss in s:
            if check(ss):
                cnt[x] += 1
            if ss[-1] in ['.', '!', '?']:
                x += 1
    print(f'#{t}', end=' ')
    print(*cnt)