import sys

x, y, w, h = map(int, sys.stdin.readline().split())
hansu = [x, y]
right_point = [w, h]
min_value = 0

if abs(hansu[0] - right_point[0]) < abs(hansu[1] - right_point[1]):
    min_value = abs(hansu[0] - right_point[0])
else:
    min_value = abs(hansu[1] - right_point[1])

if abs(hansu[0] - 0) < abs(hansu[1] - 0):
    if abs(hansu[0] - 0) < min_value:
        min_value = abs(hansu[0] - 0)
else:
    if abs(hansu[1] - 0) < min_value:
        min_value = abs(hansu[1] - 0)
print(min_value)
