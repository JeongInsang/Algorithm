def palindrome(n):
    if str(n) == str(n)[::-1]:
        return True
    return False


t = int(input())
for tc in range(1, t + 1):
    n, m = map(int, input().split())
    answer = 0

    for i in range(n, m+1):
        if palindrome(i) and str(i ** 0.5)[-1] == '0' and palindrome(int(i ** 0.5)):
            answer += 1
    print(f'#{tc} {answer}')