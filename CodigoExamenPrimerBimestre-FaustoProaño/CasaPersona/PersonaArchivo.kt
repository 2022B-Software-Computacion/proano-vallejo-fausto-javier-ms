import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class PersonaArchivo {
    val path = "C:/Users/proan/IdeaProjects/CasaPersona/persona.txt"
    val gestorCasa = CasaArchivo()
    fun crearPersona(persona: Persona): Boolean {
        val file = File(path)
        file.appendText(persona.toFile())
        return true
    }

    fun bucarPersonaPorID(id: Int?): Persona {
        var persona = Persona()
        val file = File(path)
        file.forEachLine {
            val datos = it.split(",")
            if (datos[0] == id.toString())
                persona = Persona(
                    datos[0].toInt(),
                    datos[1],
                    datos[2],
                    gestorCasa.bucarCasaPorID(datos[3].toInt()),
                    datos[4].toDouble(),
                    LocalDate.parse(datos[5], DateTimeFormatter.ISO_DATE),
                    datos[6].toBooleanStrictOrNull()
                )
        }
        return persona
    }

    fun bucarPersonasPorCasa(id: Int?): ArrayList<Persona> {
        val listaPersonas = ArrayList<Persona>()
        val file = File(path)
        file.forEachLine {
            val datos = it.split(",")
            if (datos[3] == id.toString())
                listaPersonas.add(
                    Persona(
                        datos[0].toInt(),
                        datos[1],
                        datos[2],
                        gestorCasa.bucarCasaPorID(datos[3].toInt()),
                        datos[4].toDouble(),
                        LocalDate.parse(datos[5], DateTimeFormatter.ISO_DATE),
                        datos[6].toBooleanStrictOrNull()
                    )
                )
        }
        return listaPersonas
    }

    fun verPersonas(): ArrayList<Persona> {
        val listaPersonas = ArrayList<Persona>()
        val file = File(path)
        file.forEachLine {
            val datos = it.split(",")
            listaPersonas.add(
                Persona(
                    datos[0].toInt(),
                    datos[1],
                    datos[2],
                    gestorCasa.bucarCasaPorID(datos[3].toInt()),
                    datos[4].toDouble(),
                    LocalDate.parse(datos[5], DateTimeFormatter.ISO_DATE),
                    datos[6].toBooleanStrictOrNull()
                )
            )

        }
        return listaPersonas
    }

    fun actualizarPersona(id: Int, persona: Persona): Boolean {
        return try {
            val file = File(path)
            val personas = verPersonas()
            file.writeText("")
            personas.forEach {
                if (it.getID() != id) {
                    file.appendText(it.toFile())
                } else {
                    file.appendText(persona.toFile())
                }
            }
            true
        } catch (e: Exception) {
            false
        }

    }

    fun eliminarPersona(id: Int): Boolean {
        return try {
            val file = File(path)
            val personaes = verPersonas()
            file.writeText("")
            personaes.forEach {
                if (it.getID() != id) {
                    file.appendText(it.toFile())
                }
            }
            true
        } catch (e: Exception) {
            false
        }

    }
}
