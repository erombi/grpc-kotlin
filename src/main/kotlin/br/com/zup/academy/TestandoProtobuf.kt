package br.com.zup.academy

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {

    val request = FuncionarioRequest.newBuilder()
        .setNome("Eduardo")
        .setCpf("000.000.000-00")
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(Endereco.newBuilder()
            .setLogradouro("Rua das casas")
            .setCep("1215")
            .setComplemento("Complemento"))
        .build()

        println(request)

        request.writeTo(FileOutputStream("funcionario-request.bin"))

        val request2 = FuncionarioRequest.newBuilder().mergeFrom(FileInputStream("funcionario-request.bin"))

        println(request2)
}