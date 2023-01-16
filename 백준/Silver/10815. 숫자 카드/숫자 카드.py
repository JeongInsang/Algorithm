n = int(input())
n_arr = list(map(int, input().split()))
n_arr.sort()

m = int(input())
m_arr = list(map(int, input().split()))

for i in m_arr:
    start, end = 0, n-1
    while True:
        mid = (start + end) // 2
        if start > end:
            print(0, end = ' ')
            break
        elif n_arr[mid] > i:
            end = mid - 1
        elif n_arr[mid] < i:
            start = mid + 1
        elif n_arr[mid] == i:
            print(1, end = ' ')
            break