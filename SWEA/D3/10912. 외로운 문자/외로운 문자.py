from collections import Counter

t = int(input())

for tc in range(1, t + 1):
    s = list(input())
    temp = []

    for c, i in Counter(s).items():
        if i % 2 != 0:
            temp.append(c)

    if not temp:
        print('#{} Good'.format(tc))
    else:
        print('#{} {}'.format(tc, ''.join(sorted(temp))))