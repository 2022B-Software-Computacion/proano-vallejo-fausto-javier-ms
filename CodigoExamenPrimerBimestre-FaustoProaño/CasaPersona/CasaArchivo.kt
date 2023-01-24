import java.io.File

class CasaArchivo {
    private val path = "C:/Users/proan/IdeaProjects/CasaPersona/casa.txt"
    fun crearCasa(casa: Casa): Boolean {
        val file = File(path)
        file.appendText(casa.toFile() + "\n")
        return true
    }

    fun bucarCasaPorID(id: Int?): Casa {
        var casa = Casa()
        val file = File(path)
        file.forEachLine {
            val datos = it.split(",")
            if (datos[0] == id.toString()) {
                casa = Casa(
                    datos[0].toInt(),
                    datos[1],
                    datos[2].toDouble(),
                    datos[3].toInt(),
                    datos[4].toInt(),
                    datos[5].toBooleanStrictOrNull(),
                    datos[6].toInt()
                )
            }
        }
        return casa
    }


    fun verCasas(): ArrayList<Casa> {
        val listaCasas = ArrayList<Casa>()
        val file = File(path)
        file.forEachLine {
            val datos = it.split(",")
            listaCasas.add(
                Casa(
                    datos[0].toInt(),
                    datos[1],
                    datos[2].toDouble(),
                    datos[3].toInt(),
                    datos[4].toInt(),
                    datos[5].toBooleanStrictOrNull(),
                    datos[6].toInt()
                )
            )
        }
        return listaCasas
    }

    fun actualizarCasa(id: Int, casa: Casa): Boolean {
        return try {
            val file = File(path)
            val casas = verCasas()
            file.writeText("")
            casas.forEach {
                if (it.getID() != id) {
                    file.appendText(it.toFile() + "\n")
                } else {
                    file.appendText(casa.toFile() + "\n")
                }
            }
            true
        } catch (e: Exception) {
            false
        }

    }

    fun eliminarCasa(id: Int): Boolean {
        return try {
            val file = File(path)
            val casas = verCasas()
            file.writeText("")
            casas.forEach {
                if (it.getID() != id) {
                    file.appendText(it.toFile() + "\n")
                }
            }
            true
        } catch (e: Exception) {
            false
        }

    }
}
