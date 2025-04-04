package hotel
import kotlin.math.ceil
import kotlin.system.exitProcess
fun marcarEventos() {              // lista de dias da semana
    var auditorio = ""
    var dias = mutableListOf("domingo", "segunda", "terça", "quarta", "quinta", "sexta", "sabado")
    var diasocupados = mutableListOf<String>() // lista de dias ocupados
    println("Quem será o responsável pelo evento? ")
    var responsavel = readln()
    var numconvidados = 0
    println("Certo, para quantas pessoas será o evento?")
    numconvidados = readln().toIntOrNull() ?: -1
    do {
        if (numconvidados == -1) {
            println("Erro valor inválido $responsavel, digite novamente")
            numconvidados = readln().toIntOrNull() ?: -1
            continue
        }
        if (numconvidados > 350 || numconvidados < 0) {
            println("Quantidade inválida $responsavel, digite novamente")
            numconvidados = readln().toIntOrNull() ?: -1
            continue
        }
    } while (numconvidados > 350 || numconvidados < 0)
    if (numconvidados <= 230 && numconvidados >= 1) {
        println("Para o número de convidados, recomendamos o auditório laranja ")
        auditorio = "laranja"
    } else if (numconvidados > 230 && numconvidados <= 350) {
        println("Para o número de convidados, recomendamos o auditório colorado ")
        auditorio = "colorado"
    }
    println("Certo, temos esses dias disponíveis: ")
    dias.forEach { println("- $it") }
    println(
        "Qual dia da semana quer alugar o salão" +
                "\nOBS: segunda a sexta das 7horas às 23horas e de sábado e domingo das 7horas as 15horas"
    )
    var diaescolhido = readln().lowercase()
    if (diasocupados.contains(diaescolhido)) {
        println("A $diaescolhido já está ocupado!")
    } else if (dias.contains(diaescolhido)) {
        diasocupados.add(diaescolhido)
        dias.remove(diaescolhido)
    }
    var horainicio: Int
    do {
        println("Qual a hora do evento?")
        horainicio = readln().toIntOrNull() ?: -1
        if (diaescolhido == "sabado" || diaescolhido == "Domingo") {
            if (horainicio < 7 || horainicio > 15) {
                println("Horário inválido para sabado e domingo!")
            } else {
                break
            }
        } else {
            if (horainicio < 7 || horainicio > 23) {
                println("Hora invalida para os dias úteis")
            } else {
                break
            }
        }
    } while (true)
    println("E quantas horas de evento?")
    var horaevento = readln()
    println("Qual o nome da empresa?")
    var empresa = readln()
    println("Salão reservado para a empresa $empresa, no dia $diaescolhido, as $horainicio Horas no auditório $auditorio")
    var garcom = numconvidados / 12
    var valorgarcom = Math.round(garcom * 10.50)
    println("Número de graçons para o início do evento é $garcom e o valor é de $valorgarcom")
    var contador = 0
    while (contador < horaevento.toInt()) {
        contador = contador + 1
    }
    var totalgarcom = garcom + contador
    var contadorgarçons = Math.round(contador * 10.50)
    println(
        "Para cada hora do evento serão adicionados 1 garçom, tatal gaçons é $totalgarcom" +
                "\nvalor total de garçons é de " + (valorgarcom + contadorgarçons) + " R$"
    )
    print("\u001b[2J")
    println("Agora vamos Fazer o cáuculo do Buffet")
    var agua = ceil(numconvidados * 0.5)
    var cafe = ceil(numconvidados * 0.2)
    var salgado = numconvidados * 7
    var centodosalgo = salgado / 100
    var buffet = agua * 0.40 + cafe * 0.80 + centodosalgo * 34
    println("O evento nescessitará de um total de $agua litros de água $cafe litros de café e $salgado salgados")
    println("O custo do buffet será de R$ ${agua * 0.40 + cafe * 0.80 + centodosalgo * 34}")
    println(
        "Evento no auditório $auditorio " +
                "\nDia do evento $diaescolhido," +
                " \nInício às $horainicio horas " +
                "\nDuraçao do evento $horaevento horas +" +
                "\nquantidade de garçons $totalgarcom" +
                "\nNumero de convidados $numconvidados" +
                "\nCusto dos garçons " + (valorgarcom + contadorgarçons) + " R$" +
                "\nCusto do buffet $buffet" +
                "\nValor total d0o evento é" + (buffet + valorgarcom) + "R$")
    println("Deseja fechar o contrato? S/N")
    println("Você deseja aceitar?\n Informe 1 para \"sim\" e 0 para \"não\"")
    var fecharcontrato = readln().toIntOrNull() // digite true ou false ou 1 ou 0
    while (fecharcontrato == null) {
        println("Digite APENAS NUMEROS!")
        fecharcontrato = readln().toIntOrNull()
    }
    if (fecharcontrato == 1) {
        println("Muito obrigado e até logo, $responsavel")
        println("Contrato fechado")
        menu()
    } else {
        menu()
    }
}