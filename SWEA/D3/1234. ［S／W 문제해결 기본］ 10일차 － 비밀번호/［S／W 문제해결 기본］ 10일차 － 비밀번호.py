t = 10
for tc in range(1, t+1):
    n, m = map(str, input().split())
    m = list(m)
    queue = []
    cnt = len(m)

    while m:
        if not queue:
            queue.append(m.pop(0))
        else:
            queue.append(m.pop(0))
            if queue[-1] == queue[-2]:
                queue.pop(), queue.pop()
    answer = ''.join(queue)
    print(f'#{tc} {answer}')



