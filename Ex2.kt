package TP8

enum class TypeVehicule {
    VOITURE,
    MOTO,
    BATEAU
}

interface Navigable {
    fun naviguer(): String
}

interface VolantVehicule {
    fun voler(): String
}

sealed class Vehicule {
    abstract val nom: String
    abstract val marque: String
    abstract val type: TypeVehicule
}

data class Voiture(
    override val nom: String,
    override val marque: String
) : Vehicule() {
    override val type = TypeVehicule.VOITURE
}

data class Moto(
    override val nom: String,
    override val marque: String
) : Vehicule() {
    override val type = TypeVehicule.MOTO
}

data class Bateau(
    override val nom: String,
    override val marque: String
) : Vehicule(), Navigable {
    override val type = TypeVehicule.BATEAU

    override fun naviguer(): String {
        return "$nom navigue sur l'eau"
    }
}

fun ajouterVehicule(liste: MutableList<Vehicule>, vehicule: Vehicule) {
    liste.add(vehicule)
    println("${vehicule.nom} ajouté à l'agence")
}

fun afficherInformationsVehicule(liste: List<Vehicule>) {
    for (vehicule in liste) {
        println("${vehicule.nom} - ${vehicule.marque} - ${vehicule.type}")
    }
}

fun main() {
    val agence = mutableListOf<Vehicule>()

    val voiture = Voiture("Clio", "Renault")
    val moto = Moto("CBR", "Honda")
    val bateau = Bateau("Odyssey", "Yamaha")

    ajouterVehicule(agence, voiture)
    ajouterVehicule(agence, moto)
    ajouterVehicule(agence, bateau)

    afficherInformationsVehicule(agence)

    println(bateau.naviguer())
}