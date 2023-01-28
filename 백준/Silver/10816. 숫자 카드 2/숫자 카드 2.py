from bisect import bisect_left, bisect_right
n = int(input())
n_arr = list(map(int, input().split()))
n_arr.sort()

m = int(input())
m_arr = list(map(int, input().split()))

def cnt_range(a, left, right):
    r = bisect_right(a, right)
    l = bisect_left(a, left)
    return r - l

for i in range(len(m_arr)):
    print(cnt_range(n_arr, m_arr[i], m_arr[i]), end = ' ')