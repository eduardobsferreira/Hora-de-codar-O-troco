
var saldo = 100.5 // Float
var nome : String = ""

fun main() {
    print("Informe seu nome: ")
    nome = readLine() ?: "Usuário"
    nome = if (nome.isNullOrBlank()) "Usuário" else nome
    println("Olá $nome é um prazer ter você por aqui!")

    inicio()

}

fun inicio() {

    println("Escolha uma opção:")
    println("1. Saldo | 2. Extrato | 3. Saque | 4. Depósito | 5. Transferência | 6. Sair")

    val escolha = readLine()?.toIntOrNull()

    when (escolha) {
        1 -> verSaldo()
        2 -> verExtrato()
        3 -> fazerSaque()
        4 -> fazerDeposito()
        5 -> fazerTransferencia()
        6 -> sair()
        else -> erro()
    }
}

fun validarSenha (): Boolean {
    println("Digite sua senha: ")
    val senha = readln()?.toIntOrNull()

    if (senha == 3589){
        return true
    } else {
        println("Senha incorreta! Tente novamente.")
        return validarSenha()
    }
}

fun verSaldo() {
    if (validarSenha()){
        println("Seu saldo atual é: $saldo")
        inicio()

    }
}

fun verExtrato() {
    if (validarSenha()) {
        println("----- EXTRATO BANCÁRIO -----")
        println("Sjx atacadista : R$20,00")
        println("Sonda Vila Romana: R$ 12,00")
        println("Shopee Brasil: R$ 37,00")
        println("Recarga transporte: R$ 200,00")
        println("----------------------------")
        println("Saldo Atual: $saldo")
        inicio()
    }
}

fun fazerDeposito() {
    print("Qual o valor para depósito? ")
    val deposito = readLine()?.toFloatOrNull()

    if (deposito == null) {
        println("Por favor, informe um número válido.")
        fazerDeposito()
    } else if (deposito <= 0) {
        println("Operação não autorizada.")
        inicio()
    } else {
        saldo += deposito
        verSaldo()
    }
}

fun fazerTransferencia(){
    if (validarSenha()) {
        println("Informe o número da conta: ")
        val nConta = readLine()?.toIntOrNull()
        println("Informe o valor de Transferência: ")
        val transfer = readLine()?.toIntOrNull()

        if (nConta != null && transfer != null && transfer > 0 && transfer <= saldo){
            saldo -= transfer
            println("Transferência realizada com sucesso.")
            verSaldo()
        }
        else{
            println("Operação não autorizada.")
            inicio()
        }
    }
}

fun fazerSaque() {
    if (validarSenha()) {
        print("Qual o valor para saque? ")
        val saque = readLine()?.toFloatOrNull()

        if (saque != null && saque > 0 && saque <= saldo) {
            saldo -= saque
            println("Saque realizado com sucesso.")
            verSaldo()
        } else {
            println("Operação não autorizada.")
            inicio()
        }
    }
}

fun erro() {
    println("Por favor, informe um número entre 1 a 6.")
    inicio()
}

fun sair() {
    print("Você deseja sair? (S/N) ")
    val confirma = readLine()?.uppercase()

    if (confirma == "S"){
        println("$nome, foi um prazer ter você por aqui!")
    } else {
        inicio()
    }
}



