t = int(input())
for tc in range(1, t+1):
    n = int(input())
    answer = 0

    for i in range(1, int(n ** (1/3)) + 2):
        if i ** 3 == n:
            answer = i
    if not answer:
        print(f'#{tc} -1')
    else:
        print(f'#{tc} {answer}')