while True:
    tc = input()
    if tc == '0':
        break

    if tc[:] == tc[::-1]:
        print('yes')
    else:
        print('no')


