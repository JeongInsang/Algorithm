def solution(operations):
    answer = []
    
    for i in range(len(operations)):
        if operations[i][0] == 'I':
            answer.append(int(operations[i][2:]))
            
        elif operations[i][0] == 'D' and operations[i][2] == '-':
            if len(answer) == 0:
                continue
            else:
                answer.remove(min(answer))
            
        elif operations[i][0] == 'D' and operations[i][2] == '1':
            if len(answer) == 0:
                continue
            else:
                answer.remove(max(answer))
    
    if len(answer) == 0:
        return [0,0]
    
    else:
        return [max(answer), min(answer)]
    return answer