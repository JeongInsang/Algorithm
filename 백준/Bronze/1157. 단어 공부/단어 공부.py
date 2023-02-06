s = input()
s = s.upper()
char_dict = {}
flag = False
for char in set(s):
    char_dict[char] = s.count(char)

for i in char_dict:
    if i != max(char_dict, key=char_dict.get):
        if char_dict[i] == char_dict[max(char_dict, key=char_dict.get)]:
            flag = True
            break
    else:
        continue
if flag:
    print('?')
else:
    print(max(char_dict, key=char_dict.get))