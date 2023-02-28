from string import ascii_lowercase

l = int(input())
s = list(input())
alphabet_list = list(ascii_lowercase)
hash_sum = 0

for idx, alphabet in enumerate(s):
    hash_sum += (alphabet_list.index(alphabet) + 1) * (31**idx)
print(hash_sum)