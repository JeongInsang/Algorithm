t = int(input())
for tc in range(1, t+1):
    a_len, b_len = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    if len(a) < len(b):
        max_arr = b
        min_arr = a
    else:
        max_arr = a
        min_arr = b

    arr = [[] for _ in range(len(min_arr))]
    for i in range(len(min_arr)):
        for j in range(i, i + (len(max_arr) - len(min_arr) + 1)):
           arr[i].append(min_arr[i] * max_arr[j])

    max_sum = 0
    for i in range(len(arr[0])):
        n_sum = 0
        for j in range(len(arr)):
            n_sum += arr[j][i]
        max_sum = max(max_sum, n_sum)
    print(f'#{tc} {max_sum}')