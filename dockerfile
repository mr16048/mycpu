
FROM ubuntu:23.04

ENV RISCV=/opt/riscv
ENV PATH=$RiSCV/bin:$PATH
ENV MAKEFLAGS=-j4

WORKDIR $RISCV

RUN apt-get update
RUN apt-get install -y autoconf automake autotools-dev curl python3 python3-pip libmpc-dev libmpfr-dev libgmp-dev gawk build-essential bison flex texinfo gperf libtool patchutils bc zlib1g-dev libexpat-dev ninja-build git cmake libglib2.0-dev

RUN git clone https://github.com/riscv/riscv-gnu-toolchain &&cd riscv-gnu-toolchain  
RUN cd riscv-gnu-toolchain && mkdir build && cd build && ../configure --prefix=${RISCV} --enable-multilib && make

RUN git clone -b master --single-branch https://github.com/riscv/riscv-tests && cd riscv-tests && git checkout c4217d88bce9f805a81f42e86ff56ed363931d69 && git submodule update --init --recursive

RUN echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | tee /etc/apt/sources.list.d/sbt_old.list && curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | apt-key add && apt-get update && apt-get install -y sbt
