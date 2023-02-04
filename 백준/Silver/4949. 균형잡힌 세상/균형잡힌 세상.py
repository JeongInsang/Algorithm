while 1:
    s = input()
    if s == '.':
        break
    stack = []

    for i in s:
        if i == '(' or i == ')' or i == '[' or i == ']':
            stack.append(i)
            if len(stack) > 1:
                if (stack[-2] == '(' and stack[-1] == ')') or (stack[-2] == '[' and stack[-1] == ']'):
                    stack.pop(), stack.pop()
    if len(stack) == 0:
        print('yes')
    else:
        print('no')
