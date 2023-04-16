t = int(input())

for tc in range(1, t+1):
    n = int(input())
    arr = []
    leng = 0
    for i in range(n):
        c, k = map(str, input().split())
        arr.append([c]*int(k))
        leng += len(arr[i])

    answer = [[] for _ in range((leng//10)+1)]
    j = 0
    cnt = 0
    for i in range(n):
        while arr[i]:
            if cnt < 10:
                answer[j].append(arr[i].pop())
                cnt += 1
            else:
                j += 1
                cnt = 0

    print(f'#{tc}')
    for i in answer:
        for j in i:
            print(j, end='')
        print()