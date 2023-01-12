from heapq import heappush, heappop

def solution(n, works):
    heap = []
    if sum(works) <= n:
            return 0
        
    for i in works:
        heappush(heap, (-i, i))

    for _ in range(n):
        a = heappop(heap)[1]
        heappush(heap, (-(a-1), (a-1)))
    return sum([heap[i][1] ** 2 for i in range(len(heap))])