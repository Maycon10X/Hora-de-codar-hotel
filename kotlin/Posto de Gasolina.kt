package hotel
fun abastecerCarro(nomeDono: String, hotel: String = "Demon") {
  println("O carro precisa ser abastecido $nomeDono")
  var gasolinaPost1 = 0.0
  var gasolinaPost2 = 0.0
  var alcoolPost1 = 0.0
  var alcoolPost2 = 0.0
  var tanque = 42
  println("Informe o valor da gasolina do posto Wayne Oil")
  do {
    gasolinaPost1 = readln().toDoubleOrNull() ?: -0.1
    if (gasolinaPost1 < 0.0) {
      println("valor inválido")
    }
  } while (gasolinaPost1 < 0.0)
  println("Informe o valor do álcool do posto Wayne Oil")
  do {
    alcoolPost1 = readln().toDoubleOrNull() ?: -0.1
    if (alcoolPost1 < 0.0) {
      println("valor inválido")
    }
  } while (alcoolPost1 < 0.0)
  println("Informe o valor da gasolina do posto Stark Petrol")
  do {
    gasolinaPost2 = readln().toDoubleOrNull() ?: -0.1
    if (gasolinaPost2 < 0.0) {
      println("valor inválido")
    }
  } while (gasolinaPost2 < 0.0)
  println("Informe o valor do alcool do posto Stark Petrol")
  do {
    alcoolPost2 = readln().toDoubleOrNull() ?: -0.1
    if (alcoolPost2 < 0.0) {
      println("valor inválido")
    }
  } while (alcoolPost2 < 0.0)
  println("valor da gasolina posto 1: $gasolinaPost1 R$")
  println("valor do alcool posto 1: $alcoolPost1 R$")
  println("valor da gasolina posto 2: $gasolinaPost2 R$")
  println("valor do alcool posto 2: $alcoolPost2 R$")
  var postogasolina = if (gasolinaPost1 > gasolinaPost2) "Wayne Oil" else "Stark Petrol"
  var postoalcool = if (alcoolPost1 > alcoolPost2) "Wayne Oil" else "Stark Petrol"
  var gasolinaboa = if (gasolinaPost1 > gasolinaPost2) {
    gasolinaPost1
  } else {
    gasolinaPost2
  }
  var alcoolruim = if (alcoolPost1 > alcoolPost2) {
    alcoolPost1
  } else {
    alcoolPost2
  }
  if (gasolinaboa <= alcoolruim * 0.7) {
    println("$nomeDono, é mais barato abastecer com gasolina no posto $postogasolina")
  } else {
    println("$nomeDono, é mais barato abastecer com álcool no posto $postoalcool")
    menu()
  }
}