#include <stdio.h>

int main(){

  asm volatile("li a0, 3");
  asm volatile("li a1, 2");
  // asm volatile("slli a0, a0, 17");
  // asm volatile("slli a1, a1, 20");
  // asm volatile("addi a0, a0, 7");
  // asm volatile("addi a1, a1, 3");
  asm volatile("mul a2, a1, a0");
  
  asm volatile("unimp");

  return 0;
}