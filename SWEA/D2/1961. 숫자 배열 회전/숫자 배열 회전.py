

def func90(arr):  # 90도
    reverse = arr[::-1]
    rotated = list(zip(*reverse))
    return rotated


def func180(arr):
    reverse = arr[::-1]
    rotated = list(zip(*reverse))
    return func90(rotated)



def func270(arr):
    reverse = arr[::-1]
    rotated = list(zip(*reverse))
    return func180(rotated)


t = int(input())
for tc in range(1, t+1):
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]
    answer = []

    answer.append(func90(arr))
    answer.append(func180(arr))
    answer.append(func270(arr))

    print(f'#{tc}')
    for i in range(n):
        for j in range(3):
            for k in answer[j][i]:
                print(k, end='')
            print('', end=' ')
        print()

