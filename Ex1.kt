package TP8

enum class TypeAnimal {
    TERRESTRE,
    VOLANT,
    AQUATIQUE
}

interface Volant {
    fun voler(): String
}

interface Aquatique {
    fun nager(): String
}

sealed class Animal {
    abstract val nom: String
    abstract val espece: String
    abstract val type: TypeAnimal
}

data class Terrestre(
    override val nom: String,
    override val espece: String
) : Animal() {
    override val type = TypeAnimal.TERRESTRE
}

data class VolantAnimal(
    override val nom: String,
    override val espece: String
) : Animal(), Volant {
    override val type = TypeAnimal.VOLANT

    override fun voler(): String {
        return "$nom vole dans le ciel"
    }
}

data class AquatiqueAnimal(
    override val nom: String,
    override val espece: String
) : Animal(), Aquatique {
    override val type = TypeAnimal.AQUATIQUE

    override fun nager(): String {
        return "$nom nage dans l'eau"
    }
}

fun ajouterAnimal(liste: MutableList<Animal>, animal: Animal) {
    liste.add(animal)
}

fun main() {
    val parc = mutableListOf<Animal>()

    val lion = Terrestre("Simba", "Lion")
    val oiseau = VolantAnimal("Piou", "Moineau")
    val dauphin = AquatiqueAnimal("Flipper", "Dauphin")

    ajouterAnimal(parc, lion)
    ajouterAnimal(parc, oiseau)
    ajouterAnimal(parc, dauphin)

    println(parc)
    println(oiseau.voler())
    println(dauphin.nager())
}