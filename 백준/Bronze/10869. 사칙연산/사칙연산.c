#include <stdio.h>
int main() {
    int a, b;
    int p, m, g, n, c;

    scanf("%d %d", &a, &b);
    
    p = a + b;
    m = a - b;
    g = a * b;
    n = a / b;
    c = a % b;
    
    printf("%d\n", p);
    printf("%d\n", m);
    printf("%d\n", g);
    printf("%d\n", n);
    printf("%d\n", c);
    return 0;
}