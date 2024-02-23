package fetch
import chisel3._
import chisel3.util._
import common.Instructions._
import common.Consts._

class Multiplyer extends Module{

	val io = IO(
		new Bundle{
			val exe_fun = Input(UInt(WORD_LEN.W))
			val op1_data = Input(UInt(WORD_LEN.W))
			val op2_data = Input(UInt(WORD_LEN.W))
			val calced = Output(UInt(WORD_LEN.W))
		}
	)

  var op1_64_U = UInt(DWORD_LEN.W);
  op1_64_U = io.op1_data;
  var op2_64_U = UInt(DWORD_LEN.W);
  op2_64_U = io.op2_data;

  val op1_64_S = op1_64_U.asSInt;
  val op2_64_S = op2_64_U.asSInt;

  io.calced := MuxCase(0.U(WORD_LEN.W), Seq(
    (io.exe_fun === ALU_MUL) -> (op1_64_U * op2_64_U)(31, 0).asUInt,
    (io.exe_fun === ALU_MULH) -> ((op1_64_S * op2_64_S)>>32.U(WORD_LEN.W)).asUInt,
    (io.exe_fun === ALU_MULHSU) -> ((op1_64_S * op2_64_U)>>32.U(WORD_LEN.W)).asUInt,
    (io.exe_fun === ALU_MULHU) -> ((op1_64_U * op2_64_U)>>32.U(WORD_LEN.W)).asUInt,   
  ))

}