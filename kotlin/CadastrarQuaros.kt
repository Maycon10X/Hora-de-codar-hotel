package hotel
var quartos = MutableList(20) { "Disponível" } // coloca uma condiçao em todos os elementos da lista
fun  cadastrarQuartos(nomeDono: String, hotel: String, diaria: Double) {
    var hospedagem: Int
    println("Qual o nome do Hospede? ")
    var nomeHospede = readln()
    println("O valor da diária é $diaria!")
    do {
        print("Quantas diárias serão necessárias: ")
        hospedagem = readln().toIntOrNull() ?: -1 // garante que a variavel seja numero
        if (hospedagem <= 0 || hospedagem >= 30) {
            println("Erro, valor inválido $nomeDono, tente novamente.")
        }
    } while (hospedagem <= 0 || hospedagem >= 30)
    println("Lista de quartos do hotel $hotel")
    quartos.forEachIndexed { index, status ->    // o index cria uma posiçao para cada elemento da lista começa do 0
        println("Quarto ${index + 1}: $status")  // adiciona mais uma posiçao na lista ja que começa no 0
    }
    var escolhaquarto: Int
    do {
        print("Qual quarto você deseja hospedar? ")
        escolhaquarto = readln().toIntOrNull() ?: -1
        if (escolhaquarto !in 1..20) {
            println("Erro: Número de quarto inválido. Por favor, escolha entre 1 e 20.")
            continue
        }
        if (quartos[escolhaquarto - 1] == "Ocupado") {
            println("Erro: O quarto $escolhaquarto já está ocupado. Escolha outro:")
            escolhaquarto = -1 // Reseta para continuar no loop
        }
    }  while (escolhaquarto <= 0 || escolhaquarto >= 20)
    println("O quarto escolhido foi $escolhaquarto, o valor total está em " + (diaria * hospedagem) + "R$ Deseja confirmar a sua reserva? \nInforme 1 para \"sim\" e 0 para \"não\"")
    var confirma = readln().toIntOrNull() // digite true ou false ou 1 ou 0
    while (confirma == null){
        println("Digite apenas números!")
        confirma = readln().toIntOrNull()
    }
    if (confirma == 1) {
        println("Reserva realizada com sucesso, no quarto $escolhaquarto, obrigado $nomeHospede " +
                "\nstatus dos quartos restantes ")
    } else {
        iniciar()
    }
    if (escolhaquarto != null && escolhaquarto in 1..20) {
        quartos[escolhaquarto - 1] = "Ocupado"
    }
    quartos.forEachIndexed { index, status ->    // forEach procura a lista
        println("Quarto ${index + 1}: $status")  // index procura o elemento e status aplica sua condiçao
    }
    menu()
}