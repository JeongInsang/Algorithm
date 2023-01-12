def solution(s, c):
    answer = []
    
    dic = [{'R' : 0, 'T' : 0}, {'C' : 0, 'F' : 0},
           {'J' : 0, 'M' : 0}, {'A' : 0, 'N' : 0}]
    
    score = [0,3,2,1,0,1,2,3] # 0~6
    
    for i in range(len(s)):
        if c[i] >= 5:
            if 'R' in s[i]:
                dic[0][s[i][1]] += score[c[i]]
            if 'C' in s[i]:
                dic[1][s[i][1]] += score[c[i]]
            if 'J' in s[i]:
                dic[2][s[i][1]] += score[c[i]]
            if 'A' in s[i]:
                dic[3][s[i][1]] += score[c[i]]
                
        elif c[i] <= 3:
            if 'R' in s[i]:
                dic[0][s[i][0]] += score[c[i]]
            if 'C' in s[i]:
                dic[1][s[i][0]] += score[c[i]]
            if 'J' in s[i]:
                dic[2][s[i][0]] += score[c[i]]
            if 'A' in s[i]:
                dic[3][s[i][0]] += score[c[i]]
    for j in dic:
        answer.append(max(j, key=j.get))
    return ''.join(answer)