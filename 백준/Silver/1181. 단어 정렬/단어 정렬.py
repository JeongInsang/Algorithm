#백준 단어정렬 1181번

n = int(input())
arr = []
arr_temp = []
for i in range(n):
    arr.append(input())

arr = list(set(arr))
arr.sort()

for j in range(len(arr)):
    arr_temp.append([len(arr[j]), j])
arr.sort(key=len)
for j in range(len(arr)-1):
    if len(arr[j]) == len(arr[j+1]) and arr[j] > arr[j+1]:
        arr[j], arr[j+1] = arr[j+1], arr[j]
for k in arr:
    print(k)