t = int(input())
for tc in range(1, t+1):
    s = input()
    for i in range(5):
        k = 1
        for j in range(4 * len(s) + 1):
            if i == 0 or i == 4:
                if j == 4 * k - 2:
                    print('#', end='')
                    k += 1
                else:
                    print('.', end='')
            elif i == 1 or i == 3:
                if j % 2 == 0:
                    print('.', end='')
                else:
                    print('#', end='')
            else:
                if j == 4 * k - 2:
                    print(s[k-1], end='')
                    k += 1
                elif j != 4 * k - 2 and j % 2 == 0:
                    print('#', end='')
                else:
                    print('.', end='')
        print()