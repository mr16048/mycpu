#include <stdio.h>

int main(){

  unsigned int size = 5;
  unsigned int vl;

  unsigned long long x[] = {
    0x1111111111111111, 0x2222222222222222, 0x3333333333333333, 
    0x4444444444444444, 0x5555555555555555
  };
  unsigned long long *xp = x;

  while(size > 0){
    asm volatile("vsetvli %0, %1, e64, m1" :"=r"(vl) :"r"(size));
    // asm volatile("addi a0, a0, 0");
    // asm volatile("vsetvli a0, a1, 2");

    size -=vl;

    asm volatile("vle64.v v1, (%0)" ::"r"(xp));
    xp += vl;
  }

  asm volatile("unimp");
  return 0;
}