t = int(input())
for tc in range(1, t+1):
    arr = [int(i) for i in input()]
    clap = 0
    answer = 0

    for i in range(len(arr)):
        if i == 0:
            clap += arr[i]
        else:
            while clap < i:
                answer += 1
                # arr[i-1] += 1
                clap += 1
            clap += arr[i]

    print(f'#{tc} {answer}')