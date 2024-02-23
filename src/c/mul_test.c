#include <stdio.h>

int main(){

  int x = 2;
  int y = 3;

  return multiply(x, y);
  
  asm volatile("unimp");

  return 0;
}

int multiply(int x, int y){
  return x*y;
}