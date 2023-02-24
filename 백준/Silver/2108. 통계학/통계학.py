from collections import Counter
import sys

n = int(sys.stdin.readline())
nums = []
for i in range(n):
    nums.append(int(sys.stdin.readline()))
nums.sort()


def cnt_mode(numbers):
    order = Counter(numbers).most_common()
    maximum = order[0][1]
    modes = []
    for num in order:
        if num[1] == maximum:
            modes.append(num[0])
    return modes


aver = round(sum(nums) / n)
mid = nums[int(len(nums) / 2)]
mode = cnt_mode(nums)
mode.sort()
num_range = max(nums) - min(nums)

print(aver)
print(mid)
if len(mode) == 1:
    print(mode[0])
else:
    print(mode[1])
print(num_range)
