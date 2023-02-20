from itertools import combinations

t = int(input())

for tc in range(1, t + 1):
    n = list(input())
    n_max = int(''.join(n))
    n_min = int(''.join(n))
    idx = [a for a in range(len(n))]

    for i, j in combinations(idx, 2):
        n[i], n[j] = n[j], n[i]  # 0 1 1 0
        if n[0] == '0':
            n[i], n[j] = n[j], n[i]  # 1 0 0 1
            continue
        num = int(''.join(n))
        if num < n_min:
            n_min = num
        elif n_max < num:
            n_max = num
        n[i], n[j] = n[j], n[i]
    print(f'#{tc} {n_min} {n_max}')