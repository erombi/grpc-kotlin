package br.com.zup.academy

import io.grpc.ManagedChannelBuilder

fun main() {
    val channel = ManagedChannelBuilder.forAddress("localhost", 50051)
        .usePlaintext()
        .build()

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

    val client = FuncionarioServiceGrpc.newBlockingStub(channel)

    val response = client.cadastrar(request)

    println(response)
}