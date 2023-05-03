t = int(input())
for tc in range(1, t+1):
    area = int(input())
    farm = [list(input()) for _ in range(area)]
    answer = 0
    temp = area // 2

    for i in range(area):
        if i <= temp:
            for j in range(temp-i, temp+i+1):
                answer += int(farm[i][j])
        else:
            for k in range(i-temp, area - (i - temp)):
                answer += int(farm[i][k])
    print(f'#{tc} {answer}')
