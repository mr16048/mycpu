#include <stdio.h>

int main(){

  unsigned int size = 10;
  unsigned int vl;

  while(size > 0){
    asm volatile("vsetvli %0, %1, e32, m2" :"=r"(vl) :"r"(size));
    // asm volatile("addi a0, a0, 0");
    // asm volatile("vsetvli a0, a1, 2");

    size -=vl;
  }

  asm volatile("unimp");
  return 0;
}