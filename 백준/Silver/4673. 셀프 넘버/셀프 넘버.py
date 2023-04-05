arr = [i for i in range(1, 10000)]

for i in range(1,10000):
    if i < 10:
        new = i + (i % 10)

    if i < 100:
        new = i + (i % 10) + (i // 10)

    if i < 1000:
        new = i + (i // 100) + ((i % 100) // 10) + ((i % 100) % 10)

    if i < 10000:
        new = i + (i // 1000) + ((i % 1000) // 100) + (((i % 1000) % 100) // 10) + (((i % 1000) % 100) % 10)

    if new in arr:
        arr.remove(new)

for j in arr:
    print(j)