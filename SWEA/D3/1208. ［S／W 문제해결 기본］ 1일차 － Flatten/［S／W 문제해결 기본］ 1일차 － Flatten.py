t = 10
for tc in range(1, t+1):
    n = int(input())
    height = list(map(int, input().split()))

    for _ in range(n):
        min_idx, max_idx = height.index(min(height)), height.index(max(height))
        height[min_idx] += 1
        height[max_idx] -= 1

    print(f'#{tc} {max(height) - min(height)}')