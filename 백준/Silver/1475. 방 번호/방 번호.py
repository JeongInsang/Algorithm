import math

nums = list(input())
num_dic = {}
answer = 0

for num in nums:
    if num not in num_dic:
        if num == '9':
            if '6' in num_dic:
                num_dic['6'] += 1
            else:
                num_dic['6'] = 1
        else:
            num_dic[num] = 1
    else:
        num_dic[num] += 1
if '6' in num_dic:
    num_dic['6'] = math.ceil(num_dic['6'] / 2)
print(max(num_dic.values()))
