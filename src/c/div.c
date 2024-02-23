#include <stdio.h>

int main(){

  asm volatile("li a0, 0");
  asm volatile("li a1, 5");
  asm volatile("divu a2, a1, a0");
  
  asm volatile("unimp");

  return 0;
}