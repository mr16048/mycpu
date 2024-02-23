%: %.c  #ターゲット:依存ファイル群
#ターゲット：生成されるファイル
#依存ファイル：ターゲットの生成に必要なファイル

#$@: target name
#$>: 最初の依存ファイル名

	riscv64-unknown-elf-gcc -O2 -march=rv32imv -mabi=ilp32 -c -o $@.o $<
	riscv64-unknown-elf-ld -b elf32-littleriscv $@.o -T link.ld -o $@
	riscv64-unknown-elf-objcopy -O binary $@ $@.bin
	od -An -tx1 -w1 -v $@.bin > ../hex/$@.hex 
	riscv64-unknown-elf-objdump -b elf32-littleriscv -D $@ > ../dump/$@.elf.dmp

	rm -f $@.o
	rm -f $@
	rm -f $@.bin