t = 10
for tc in range(1, t+1):
    n = int(input())
    nums = list(map(int, input().split()))

    while 0 not in nums:
        for i in range(1, 6):
            if nums[0] - i <= 0:
                nums.pop(0)
                nums.append(0)
                break
            else:
                nums.append(nums.pop(0) - i)
    print(f'#{tc}', end=' ')
    print(*nums)