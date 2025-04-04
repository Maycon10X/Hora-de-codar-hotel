package hotel
import kotlin.system.exitProcess
var novoHospede = ""
var cont = 0
fun cadastrarHospedes(diaria: String, hotel: String = "Demon") {
    comeco()
}
var listaHospedes = mutableListOf(
    "Carlos Villagran",
    "Maria Antonieta de las Nieves",
    "Roberto Gómez Bolaños",
    "Florinda Meza",
    "Ramón Valdés",
    "Rubén Aguirre",
    "Angelines Fernández",
    "Edgar Vivar",
    "Horácio Gómez Bolaños",
    "Raúl Padilla"
)
fun comeco(){
    println("O valor da diária é $diaria")
    while (true) {
        println("""Cadastro de Hóspedes
        Selecione uma opção:
      1. Cadastrar
      2. Pesquisar
      3. Mostar Hóspedes
      4. Menu
      5. Sair""")
        val escolha = readln().toIntOrNull()
        when (escolha) {
            1 -> cadastrarNovoHospede(listaHospedes)
            2 -> pesquisarHospede(listaHospedes)
            3 -> mostrarhospedes()
            4 -> menu()
            5 -> sairCadastroDeHospedes()
            else -> erroCadastroDeHospedes()
        }
    }
}
fun cadastrarNovoHospede(listaHospedes: MutableList<String>) {
    var inteira = 0
    var meiaentrada = 0
    var valorhospedagem = 0.0
    var gratuidade = 0
    while (true) {
        if (cont == 15) {
            println("Máximos de cadastros atingidos")
            break
        }
        println("Informe o nome do hóspede:")
        novoHospede = readln()
        println("Por favor, informe a idade do hóspede ")
        if (novoHospede.equals("pare", ignoreCase = true)) {
            break
        }
        var idade = readln().toIntOrNull()
        if (idade != null) {
            when {
                idade <= 6 -> {
                    gratuidade++
                    println("Hóspede $novoHospede tem direito a gratuidade!")
                }
                idade <= 7 && idade >= 59 -> {
                    inteira++
                    println("Hóspede $novoHospede tem direito a inteira!")
                }
                idade >= 60 -> {
                    meiaentrada++
                    println("Hóspede $novoHospede tem direito a meia diária!")
                }
            }
            println("$novoHospede cadastro com sucesso!")
            listaHospedes.add(novoHospede)
            cont++
        } else {
            println("entrada inválida! Por favor, insira um número válido para a idade.")
        }
    }
    for (novoHospede in listaHospedes) {
        println(novoHospede)
    }
    println(" A quantidade de gratuidades é $gratuidade" )
    println(" A quantidade de meiaentrada é $meiaentrada" )
    println(" A quantidade de inteira é $inteira")
    valorhospedagem = (meiaentrada*(diaria/2)) + (inteira*diaria)
    println(" O valor total da diaria é $valorhospedagem")
}
// Não é necessário chamar a função cadastrarHospedes(), pois o loop while já está chamando.
fun pesquisarHospede(listaHospedes: MutableList<String>) {
    println("Pesquisa de Hóspedes.\nPor favor, informe o nome da Hóspede:")
    val nomeHospede = readln()
    // Se o nome do hóspede estiver na lista, exibir o nome do hóspede.
    if (listaHospedes.any { it.contains(nomeHospede, ignoreCase = true) }) {
        println("\nEncontramos a(s) hóspede(s):")
        // filter irá filtrar a lista de hóspedes e exibir apenas os que contém o nome informado.
        listaHospedes.filter { it.contains(nomeHospede, ignoreCase = true) } // ignoreCase = true fará com que a busca não seja case sensitive.
            .forEach { println(it) } // forEach irá exibir cada hóspede encontrado.
    } else {
        println("Não encontramos nenhuma hóspede com esse nome.")
    }
}
fun sairCadastroDeHospedes() {
    println("Você deseja sair? S/N")
    val escolha = readln()
    when (escolha.uppercase()) {
        // uppercase fará o que for digitado ser convertido para maiúsculo por exemplpo x -> X
        "S" -> {
            println("Hasta la vista, Baby.")
            exitProcess(0)
        }
        "N" -> {
            println("Ok, voltando ao início.")
            comeco()
        }
        else -> {
            println("Desculpe, mas não compreendi.")
            sairCadastroDeHospedes()
        }
    }
}
fun erroCadastroDeHospedes() {
    println("Por favor, informe um número entre 1 e 6.")
}
fun mostrarhospedes() {
    println("Lista de hóspedes")
    for (novoHospede in listaHospedes) {
        println(novoHospede)
    }
}