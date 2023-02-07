import sys
# sys.stdin.readline()

t = int(sys.stdin.readline())
for _ in range(t):
    r, s = map(str, input().split())
    p = ''
    for i in range(len(s)):
        p += s[i] * int(r)
    print(p)