# SW Expert Academy D3 체스판 위의 룩 배치(보류)

t = int(input())
arr = [i for i in range(8)]

for tc in range(1, t + 1):
    rook = []
    ck = []
    for i in range(8):
        rook.append(list(input()))

    for r in rook:
        if r.count('O') == 1:
            if r.index('O') in ck:
                print('#{} no'.format(tc))
                break
            ck.append(r.index('O'))

        else:
            print('#{} no'.format(tc))
            break

    ck.sort()
    if ck == arr:
        print('#{} yes'.format(tc))