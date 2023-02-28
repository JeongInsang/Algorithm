n = input()
cnt = 0
for num in range(1, int(n) + 1):
    if num < 100:
        cnt += 1
    else:
        nums = list(map(int, str(num)))
        if nums[0] - nums[1] == nums[1] - nums[2]:
            cnt += 1
print(cnt)