t = int(input())
for tc in range(1, t+1):
    n, m = map(str, input().split())
    num_arr = list(input().split())
    num_list = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]

    for i in range(len(num_arr)):
        num_arr[i] = num_list.index(num_arr[i])
    num_arr.sort()

    for j in range(len(num_arr)):
        num_arr[j] = num_list[num_arr[j]]
    print(f'#{tc}')
    print(*num_arr)


