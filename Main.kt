package hotel
import kotlin.system.exitProcess
var diaria = 0.0
var senhah = 2678
var hotel = "Demon"
var nomeDono = ""
fun main() {
    // Função principal que chama a função inicio().
    iniciar()
}
fun iniciar() {
    print("Bem vindo ao $hotel\n")
    print("Qual o seu nome?\n")
    var nomeDono = readln()
    println("Olá $nomeDono, digite sua senha para entrar no sistema: ")
    var senha = readln().toInt()
    while (senha != senhah) {
        println("Senha incorreta, digite sua senha novamente:")
        senha = readln().toInt()
    }
    println("Senha cadastrada com sucesso \nBem vindo ao $hotel, $nomeDono É um imenso prazer ter você por aqui!")
    cadastrardiaria()
}
fun cadastrardiaria() {
    println("Qual o valor da diária do Hotel?")
    diaria = readln().toDoubleOrNull()!!
    while (diaria == null) {
        println("Digite APENAS NÚMEROS!")
        diaria = readln().toDoubleOrNull()!!
    }
    println("O valor da diária está em R$$diaria")
    menu()
}
fun menu(){
    println ("Escolha uma opção:\n1 -cadastrarQuartos\n" +
            "2 -cadastrarHospedes\n" +
            "3 -AbastecimentoDeAutomoveis\n" +
            "4 -cadastrar nova diária\n" +
            "5 -sairDo$hotel")
    // A varival escolha armazena a opção escolhida pelo usuário.
    // uma variavel local é utilizada apenas dentro da função inicio().
    val escolha = readln().toIntOrNull()
    when (escolha) {
        1 -> cadastrarQuartos(nomeDono, hotel, diaria)
        2 -> cadastrarHospedes(hotel)
        3 -> AbastecimentoDeAutomoveis()
        4 -> cadastrardiaria()
        5 -> sairDoHotel(nomeDono)
        else -> erro()
    }
}
fun AbastecimentoDeAutomoveis() {

}
fun sairDoHotel(
    nomeDono: String) {
    println("Você deseja sair?\n Informe 1 para \"sim\" e 0 para \"não\"")
    var confirma = readln().toIntOrNull() // digite true ou false ou 1 ou 0
    while (confirma == null){
        println("Digite APENAS NUMEROS!")
        confirma = readln().toIntOrNull()
    }
    if (confirma == 1) {
        println("Muito obrigado e até logo, $nomeDono")
        exitProcess(0)
    } else {
        menu()
    }
}
fun erro(){
    println("Por favor, informe um número entre 1 e 4.")
    menu()
}