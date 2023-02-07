#include <stdio.h>
int main() {
  int h, m;

  scanf("%d %d", &h, &m);

  if(m < 45) {
    h = h - 1;
    if(h < 0) h = 23;
    m = m + 15;
    printf("%d %d", h, m);
  }

  else if(m >= 45){
    m = m - 45;
    printf("%d %d", h, m);
  }

  return 0;
}
