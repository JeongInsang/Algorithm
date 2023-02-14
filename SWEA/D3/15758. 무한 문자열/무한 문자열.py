t = int(input())

for tc in range(1, t+1):
    s, t = map(str, input().split())
    if s * len(t) == t * len(s):
        print('#{} yes'.format(tc))
    else:
        print('#{} no'.format(tc))
