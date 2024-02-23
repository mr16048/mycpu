#include <stdio.h>

int main(){

  unsigned int size = 5;
  unsigned int vl;

  unsigned int x[] = {
    0x11111111, 0x22222222, 0x33333333, 0x44444444,0x55555555
  };
  unsigned int *xp = x;

  while(size > 0){
    asm volatile("vsetvli %0, %1, e32, m1" :"=r"(vl) :"r"(size));
    // asm volatile("addi a0, a0, 0");
    // asm volatile("vsetvli a0, a1, 2");

    size -=vl;

    asm volatile("vle32.v v1, (%0)" ::"r"(xp));
    xp += vl;
  }

  asm volatile("unimp");
  return 0;
}