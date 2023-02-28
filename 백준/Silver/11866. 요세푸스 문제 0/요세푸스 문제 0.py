n, k = map(int, input().split())
k -= 1
arr = [i for i in range(1, n+1)]
answer = []
num = 0

for t in range(n):
    num += k
    if num >= len(arr):
        num = num % len(arr)
    answer.append(arr.pop(num))

print('<', end='')
for i in answer:
    if i == answer[-1]:
        print(i, end='')
    else:
        print(i, end=', ')
print('>')
