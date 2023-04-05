arr = set(range(1, 10000))
new = set()

for num in arr:
    for n in str(num):
        num += int(n)
    new.add(num)

answer = arr - new
for i in sorted(answer):
    print(i)


