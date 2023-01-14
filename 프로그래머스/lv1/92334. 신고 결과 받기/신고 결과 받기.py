from collections import defaultdict

def solution(id_list, report,k):
    answer = []
    
    report = list(set(report)) # 중복 신고 제거
    user = defaultdict(set) # user별 신고한 id 저장
    cnt = defaultdict(int) # user별 신고당한 횟수 저장
	
    for r in report:
        a,b = r.split() # report의 첫번째 값은 신고자id, 두번째 값은 신고당한 id
        user[a].add(b) # 신고자가 신고한 id 추가
        cnt[b] += 1 # 신고당한 id의 신고 횟수 추가
    
    for i in id_list:
        result = 0
        for u in user[i]: # user가 신고한 id가 k번 이상 신고 당했으면, 받을 메일 추가
            if cnt[u]>=k:
                result +=1
        answer.append(result)
    return answer