package hotel

import kotlin.system.exitProcess

data class Condicionado(
    var empresas: String,
    var aparelhos: Int,
    var aparelhoMinimo: Int,
    var desconto: Int,
)
val arcond = mutableListOf<Condicionado>()
var empresaComMenorValor: String? = null
fun arcondicionado() {
    println("Olá, $nomeDono vamos formalizar o contrato de manutenção dos ArCondicionados.")
    condar()
}
var menorValorContrato: Double?  = null
fun condar() {
    println("Informe o valor do serviço por aparelho: ")
    var valormanutencao = 0.0
    do {
        valormanutencao = readln().toDoubleOrNull() ?: -0.1
        if (valormanutencao <= 0.0) {
            println("valor inválido")
        }
    } while (valormanutencao <= 0.0)
    println("Qual a quantidade de aparelhos? ")
    var aparelhos = 0
    do {
        aparelhos = readln().toIntOrNull() ?: -1
        if (aparelhos <= 0) {
            println("valor inválido")
        }
    } while (aparelhos <= 0)
    println("Qual o nome da empresa ? ")
    var empresas = readln()
    var desconto = 0
    do {
        println("Qual a porcentagem de desconto?")
        desconto = readln().toIntOrNull() ?: -1
        if (desconto < 0 || desconto > 100) {
            println("Inválido digite novamente")
            desconto = readln().toIntOrNull() ?: -1
        }
    } while (desconto < 0 || desconto > 100)
    println("E qual a quantidade mínima de aparelhos para ter desconto? ")
    var aparelhoMinimo = 0
    do {
        aparelhoMinimo = readln().toIntOrNull() ?: -1
        if (aparelhoMinimo < 0) {
            println("valor inválido")
        }
    } while (aparelhoMinimo < 0)
    arcond.add(Condicionado(empresas, aparelhos, aparelhoMinimo, desconto))
    println(Condicionado(empresas, aparelhos, aparelhoMinimo, desconto))
    var valorarcond = aparelhos * valormanutencao
    var valortotal = (valorarcond - (valorarcond * desconto) / 100)
    if (aparelhoMinimo <= aparelhos) {
        print("O serviço da empresa $empresas custará " + valortotal + "R$")

        if (menorValorContrato == null || valortotal < menorValorContrato!!) {
            menorValorContrato = valortotal
            empresaComMenorValor = empresas

        }
        println("O menor valor de contrato é: $menorValorContrato R$ da empresa $empresaComMenorValor")
        println("\nDeseja inserir novas dados (S/N)?")
        println("Informe 1 para \"sim\" e 0 para \"não\"")
        var confirma = readln().toIntOrNull() // digite true ou false ou 1 ou 0
        while (confirma == null) {
            println("Digite APENAS NUMEROS!")
            confirma = readln().toIntOrNull()
        }
        if (confirma == 1) {
            condar()
        } else {
            menu()
        }
    }
}

