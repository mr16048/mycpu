package vle
import chisel3._ 
import fetch._
// ChiselTest を 利用 する ため に 必要 な package 
import org.scalatest._ 
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class HexTest extends AnyFlatSpec with ChiselScalatestTester{

  "mycpu" should "work through hex" in {
    test(new Top){
      c => while(!c.io.exit.peek().litToBoolean){
        c.clock.step(1)
      } 
    }
  }
}
