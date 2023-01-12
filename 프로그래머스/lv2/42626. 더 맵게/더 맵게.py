from heapq import heappop, heappush

def solution(s, K):
    answer = []
    cnt = 0
    
    for i in range(len(s)):
        heappush(answer, s[i])
    
    while answer[0] < K:
        if len(answer) == 1:
            return -1
        else:
            a = heappop(answer)
            heappush(answer, a + (heappop(answer) * 2))
            cnt += 1        
            
    return cnt