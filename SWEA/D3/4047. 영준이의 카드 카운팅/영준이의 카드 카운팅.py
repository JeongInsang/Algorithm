t = int(input())
for tc in range(1, t + 1):
    s = input()
    card_len = int(len(s) / 3)
    card = {s[i:i+3] for i in range(0, len(s), 3)}
    s, d, h, c = 13, 13, 13, 13

    if card_len != len(card):
        print(f'#{tc} ERROR')
    else:
        for i in card:
            if i[0] == 'S':
                s -= 1
            elif i[0] == 'D':
                d -= 1
            elif i[0] == 'H':
                h -= 1
            else:
                c -= 1
        print(f'#{tc} {s} {d} {h} {c}')