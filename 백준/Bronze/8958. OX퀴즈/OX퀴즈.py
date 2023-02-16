tc = int(input())

for _ in range(tc):
    quiz = list(input())
    answer, cnt = 0, 1
    flag = False

    for i in range(len(quiz)):
        if quiz[i] == 'O' and flag == False:
            answer += 1
            flag = True
        elif quiz[i] == 'O' and flag == True:
            cnt += 1
            answer += cnt
        else:
            flag = False
            cnt = 1
    print(answer)
