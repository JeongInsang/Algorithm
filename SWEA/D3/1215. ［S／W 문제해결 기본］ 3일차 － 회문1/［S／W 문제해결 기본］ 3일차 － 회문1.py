def func(input_list, n):
    answer = 0

    for i in input_list:
        for j in range(8-n+1):
            if ''.join(i[j:j+n]) == ''.join((i[j:j+n])[::-1]):
                answer += 1

    new_list = list(map(list, zip(*input_list[::-1])))
    for i in new_list:
        for j in range(8 - n+1):
            if ''.join(i[j:j + n]) == ''.join((i[j:j + n])[::-1]):
                answer += 1
    return answer


t = 10
for tc in range(1, t+1):
    n = int(input())
    arr = [list(input()) for _ in range(8)]
    print(f'#{tc} {func(arr, n)}')
