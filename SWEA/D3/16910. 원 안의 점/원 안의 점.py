t = int(input())
for tc in range(1, t+1):
    n = int(input())
    answer = 0

    for i in range(-n, n+1):
        for j in range(-n, n+1):
            if i**2 + j**2 <= n**2:
                answer += 1
    print(f'#{tc} {answer}')
