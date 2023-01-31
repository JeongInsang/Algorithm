def solution(id_list, report, k):
    answer = []
    report_dict = {i: [] for i in id_list}  # 유저별 신고 유저
    user_report = {i: 0 for i in id_list}  # 유저별 신고 당한 횟수
    block_user = [] # 정지된 유저
    
    report = list(set(report))
    for i in report:
        user, report_user = i.split()
        report_dict[user].append(report_user) 
    
    for report_user in report_dict.values():
        for j in report_user:
            user_report[j] += 1
            if user_report[j] >= k:
                block_user.append(j)
    
    for i in report_dict.values():
        answer.append(len(set(block_user) & set(i)))

    return answer