t = int(input())
for tc in range(1, t+1):
    a, b, c = map(int, input().split())
    min_bread = min(a, b)
    answer = 0
    price = 0

    while 1:
        if price > c:
            answer -= 1
            break
        price += min_bread
        answer += 1
    print(f'#{tc} {answer}')