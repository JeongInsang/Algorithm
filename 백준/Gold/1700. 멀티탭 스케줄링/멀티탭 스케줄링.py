import sys
n, k = map(int, sys.stdin.readline().split())
item = list(map(int, sys.stdin.readline().split()))
plag = []
cnt = 0

for i in range(len(item)):
    if len(plag) < n:
        if not plag:
            plag.append(item[i])
        else:
            if item[i] not in plag:
                plag.append(item[i])

    else:
        if item[i] not in plag:
            plag_idx = 0
            check = 0
            for j in plag:
                if j not in item[i:]:  # 앞으로 사용하지 않는 물건이면 체크
                    check = j
                    break

                elif item[i:].index(j) > plag_idx:  # 꽂혀 있는 물건 모두 앞으로 사용한다면 가장 늦게 사용하는 물건을 체크
                    plag_idx = item[i:].index(j)
                    check = j
            plag[plag.index(check)] = item[i]
            cnt += 1
        else:
            continue
print(cnt)