t = int(input()) # 테스트 케이스 개수

for _ in range(t): 
    room = int(input()) # 방의 개수
    door = [1] * room # 1이면 open, 0이면 close
    k = 2 # 2라운드 부터 시작
    while room >= k:
        for i in range(k-1, room, k):
            if door[i] == 1:  
                door[i] = 0 #문이 열려 있으면 닫음
            else:
                door[i] = 1 #문이 닫혀 있으면 열음
        k += 1
    print(door.count(1))
