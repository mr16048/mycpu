package fetch
import chisel3._
import chisel3.util._
import common.Instructions._
import common.Consts._

class Divider extends Module{

	val io = IO(
		new Bundle{
			val exe_fun = Input(UInt(WORD_LEN.W))
			val op1_data = Input(UInt(WORD_LEN.W))
			val op2_data = Input(UInt(WORD_LEN.W))
			val calced = Output(UInt(WORD_LEN.W))
		}
	)

  val op1_data_s = io.op1_data.asSInt;
  val op2_data_s = io.op2_data.asSInt;

  io.calced := MuxCase(0.U(WORD_LEN.W), Seq(
    (io.exe_fun === ALU_DIV) -> (devide_s(op1_data_s, op2_data_s)),
    (io.exe_fun === ALU_DIVU) -> (devide_u(io.op1_data , io.op2_data)),
    (io.exe_fun === ALU_REM) -> (rem_s(op1_data_s, op2_data_s)),
    (io.exe_fun === ALU_REMU) -> (rem_u(io.op1_data, io.op2_data)),
    // (io.exe_fun === ALU_REM) -> (if (div_by_0) op1_data else (op1_data_s % op2_data_s).asUInt),
    // (io.exe_fun === ALU_REMU) -> (if (div_by_0) op1_data else op1_data % op2_data),
  ))

	def devide_s(op1:chisel3.SInt, op2:chisel3.SInt) : chisel3.UInt = {
    
    val retS = Mux(op2 === 0.S(WORD_LEN.W), 0xFFFFFFFF.S(WORD_LEN.W), (op1/op2));

    return retS.asUInt
  }

  def devide_u(op1:chisel3.UInt, op2:chisel3.UInt) : chisel3.UInt = {
    
    val retS = Mux(op2 === 0.U(WORD_LEN.W), 0xFFFFFFFF.S(WORD_LEN.W).asUInt, (op1/op2));

    return retS.asUInt
  }

  def rem_s(op1:chisel3.SInt, op2:chisel3.SInt) : chisel3.UInt = {
    
    val retS = Mux(op2 === 0.S(WORD_LEN.W), op1, (op1 % op2));

    return retS.asUInt
  }
  
  def rem_u(op1:chisel3.UInt, op2:chisel3.UInt) : chisel3.UInt = {
    
    val retS = Mux(op2 === 0.U(WORD_LEN.W), op1, (op1 % op2));

    return retS.asUInt
  }

  
}