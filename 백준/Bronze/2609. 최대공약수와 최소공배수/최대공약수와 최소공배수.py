a, b = map(int, input().split())

def GCD(x, y):
    while y:
        x, y = y, x % y
    return x

def LCM(x, y):
    return (x * y) // GCD(x, y)

print(GCD(a, b))
print(LCM(a, b))