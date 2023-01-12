# Lv2 할인 행사 
def solution(w, n, d):
    
    answer = 0
    ck = [0] * len(n)
    
    for k in range(len(d) - 9):
        arr = n.copy()
        for i in range(k, k+10):
            if d[i] in w:
                arr[w.index(d[i])] -= 1
        if arr == ck:
            answer += 1
    return answer
