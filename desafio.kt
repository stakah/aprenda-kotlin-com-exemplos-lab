// [Template no Kotlin Playground](https://pl.kotl.in/O-xdp1Nlk)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(var nome: String, val id: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        
    }
    
    fun prettyPrint() {
        println("+========================================+")
        println(String.format("| Formacao: %-28s |", nome))
        println("|----------------------------------------|")
        println("| Conteudo Educacional:                  |")
        println("|----------------------------------------|")
        println("| Nome                     | Duracao (h) |")
        println("|--------------------------|-------------|")
        for (ce in conteudos) {
            println(String.format("| %-24s | %11d |", ce.nome, ce.duracao))
        }
        println("|----------------------------------------|")
        println("| Inscritos:                             |")
        println("|----------------------------------------|")
        println("| Id |Nome                               |")
        for (aluno in inscritos) {
            println(String.format("| %2d | %-33s |", aluno.id, aluno.nome))
        }
        println("+========================================+\n")
	}
}

fun main() {
    val formFull = Formacao(nome = "Dev Fullstack Kotlin", 
        conteudos = listOf<ConteudoEducacional>(
            ConteudoEducacional("Kotlin", 60), 
        	ConteudoEducacional("Kotlin para Android", 64),
        )
    )
    
    with (formFull) {
        matricular(Usuario(nome = "Peter Parker", id=1))
        matricular(Usuario(nome = "Mary Jane", id=2))
        prettyPrint()
    }

    val formBack = Formacao(nome = "Dev Back Java", 
        conteudos = listOf<ConteudoEducacional>(
        	ConteudoEducacional(nome="Java", duracao=120),
        )
    )
	with (formBack) {
      matricular(Usuario(nome = "Harry Potter", id=3))
      matricular(Usuario(nome = "Ermione Granger", id=4))
      prettyPrint()
    }
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    
}

