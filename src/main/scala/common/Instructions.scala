package common

import chisel3._
import chisel3.util._
import chisel3.util.BitPat

object Instructions{
//ロード・ストア
  val LW = BitPat("b?????????????????010?????0000011")
  val SW = BitPat("b?????????????????010?????0100011")

//加算
  val ADD = BitPat("b0000000??????????000?????0110011")
  val ADDI= BitPat("b?????????????????000?????0010011")

//減算
  val SUB = BitPat("b0100000??????????000?????0110011")

//論理演算
  val AND = BitPat("b0000000??????????111?????0110011")
  val OR= BitPat("b0000000??????????110?????0110011")
  val XOR = BitPat("b0000000??????????100?????0110011")
  val ANDI = BitPat("b0000000??????????111?????0010011")
  val ORI = BitPat("b0000000??????????110?????0010011")
  val XORI = BitPat("b0000000??????????100?????0010011")

//シフト
  val SLL = BitPat("b0000000??????????001?????0110011")
  val SRL = BitPat("b0000000??????????101?????0110011")
  val SRA = BitPat("b0100000??????????101?????0110011")
  val SLLI = BitPat("b0000000??????????001?????0010011")
  val SRLI = BitPat("b0000000??????????101?????0010011")
  val SRAI = BitPat("b0100000??????????101?????0010011")

//比較
  val SLT = BitPat("b0000000??????????010?????0110011")
  val SLTU = BitPat("b0000000??????????011?????0110011")
  val SLTI = BitPat("b????????????????? 010????? 0010011") 
  val SLTIU = BitPat("b????????????????? 011????? 0010011") 
  
  // 条件 分岐 
  val BEQ = BitPat("b?????????????????000?????1100011") 
  val BNE = BitPat("b?????????????????001?????1100011") 
  val BLT = BitPat("b?????????????????100?????1100011") 
  val BGE = BitPat("b?????????????????101?????1100011") 
  val BLTU = BitPat("b?????????????????110?????1100011") 
  val BGEU = BitPat("b?????????????????111?????1100011") 
  
  // ジャンプ 
  val JAL = BitPat("b?????????????????????????1101111") 
  val JALR = BitPat("b?????????????????000?????1100111") 
  
  // 即値 ロード 
  val LUI = BitPat("b?????????????????????????0110111") 
  val AUIPC = BitPat("b?????????????????????????00101111")

  // CSR 
  val CSRRW = BitPat("b?????????????????001?????1110011") 
  val CSRRWI = BitPat("b?????????????????101?????1110011") 
  val CSRRS = BitPat("b?????????????????010?????1110011") 
  val CSRRSI = BitPat("b?????????????????110?????1110011") 
  val CSRRC = BitPat("b????????????????011?????1110011") 
  val CSRRCI = BitPat("b?????????????????111?????1110011") 
  
  // 例外 
  val ECALL = BitPat("b00000000000000000000000001110011") 
  
  // ベクトル 
  val VSETVLI = BitPat("b?????????????????111?????1010111") 
  val VLE = BitPat("b000000100000?????????????0000111") 
  val VSE = BitPat("b000000100000?????????????0100111") 
  val VADDVV = BitPat("b0000001??????????000?????1010111")

  // カスタム 
  val PCNT = BitPat("b000000000000?????110?????0001011")
  
  //乗除
  val MUL = BitPat("b0000001??????????000?????0110011")
  val MULH = BitPat("b0000001??????????001?????0110011")
  val MULHSU = BitPat("b0000001??????????010?????0110011")
  val MULHU = BitPat("b0000001??????????011?????0110011")
  val DIV = BitPat("b0000001??????????100?????0110011")
  val DIVU = BitPat("b0000001??????????101?????0110011")
  val REM = BitPat("b0000001??????????110?????0110011")
  val REMU = BitPat("b0000001??????????111?????0110011")
}