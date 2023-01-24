import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


val gestorCasa = CasaArchivo()
val gestorPersona = PersonaArchivo()
val scanner = Scanner(System.`in`)
const val headerPersona =
    "\nN°\tNombres\t\t\tApellidos\t\t\tAltura\t\tFecha de Nac.\t\t¿Tiene Seguro?\t\t\tDirección\n"
const val headerCasa = "\nN°\tSuperficie\t\tAño\t\t\tPisos\t\t¿Tiene Patio?\t\tCosto\t\tDirección\n"
fun main() {
    var activo = true
    var opcion: String
    while (activo) {
        println(
            "Seleccione el archivo:\n" + "1. Persona\n" + "2. Casa\n" + "3. Salir"
        )
        opcion = scanner.nextLine()
        print(opcion)

        when (opcion) {

            ("1") -> {
                menuPersona()
            }

            ("2") -> {
                menuCasa()
            }

            else -> {
                activo = false
            }

        }

    }


}

fun menuPersona() {
    var activo = true
    var opcion: String
    var nombresPersona: String
    var apellidosPersona: String
    var casa: Casa
    var fechaNac: LocalDate
    var altura: Double
    var tieneSeguro: Boolean
    var aux: Int
    var id: Int
    var idAsignacion = 0
    while (activo) {
        print(headerPersona)
        gestorPersona.verPersonas().forEach { print(it) }
        println(
            "Seleccione la accion a realizar:\n" + "1. Agregar\n" + "2. Actualizar\n" + "3. Borrar\n" + "4. Regresar"
        )
        opcion = scanner.nextLine()

        when (opcion) {
            ("1") -> {
                print("Ingrese los nombres de la persona: ")
                nombresPersona = scanner.nextLine()
                print("Ingrese los apellidos de la persona: ")
                apellidosPersona = scanner.nextLine()
                println("Seleccione la dirección de la casa donde vive la persona: ")
                gestorCasa.verCasas().forEach {
                    println("${it.getID()} - ${it.getDireccion()}")
                }
                casa = gestorCasa.bucarCasaPorID(scanner.nextLine().toInt())
                println("Ingrese la fecha de nacimiento de la persona(yyyy-MM-dd): ")
                fechaNac = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_DATE)
                println("Ingrese la altura de la persona en metros: ")
                altura = scanner.nextLine().toDouble()
                println("¿La persona está asegurada?\n1.Si\n2.No")
                aux = scanner.nextLine().toInt()
                tieneSeguro = aux == 1
                if (gestorPersona.verPersonas().isEmpty()) {
                    idAsignacion = 1
                } else {
                    if (gestorPersona.verPersonas().last().getID() != null) {
                        idAsignacion = gestorPersona.verPersonas().last().getID()!!.plus(1)
                    }
                }
                if (gestorPersona.crearPersona(
                        Persona(
                            idAsignacion,
                            nombresPersona,
                            apellidosPersona,
                            casa,
                            altura,
                            fechaNac,
                            tieneSeguro
                        )

                    )
                ) {
                    println("Persona añadida")
                } else {
                    println("Error al añadir")
                }

            }

            ("2") -> {
                println("Seleccione la persona a actualizar (presione 0 para cancelar): ")
                print(headerPersona)
                gestorPersona.verPersonas().forEach { print(it) }
                id = scanner.nextLine().toInt()
                if (id != 0) {
                    print("Ingrese los nuevos nombres de la persona: ")
                    nombresPersona = scanner.nextLine()
                    print("Ingrese los nuevos apellidos de la persona: ")
                    apellidosPersona = scanner.nextLine()
                    println("Seleccione la nueva casa de la persona: ")
                    gestorCasa.verCasas().forEach {
                        println("${it.getID()} - ${it.getDireccion()}")
                    }
                    casa = gestorCasa.bucarCasaPorID(scanner.nextLine().toInt())
                    println("Ingrese la nueva fecha de nacimiento de la persona(yyyy-MM-dd): ")
                    fechaNac = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_DATE)
                    println("Ingrese la nueva altura de la persona en metros: ")
                    altura = scanner.nextLine().toDouble()
                    println("¿La persona está asegurada?\n1.Si\n2.No")
                    aux = scanner.nextLine().toInt()
                    tieneSeguro = aux == 1
                    if (gestorPersona.actualizarPersona(
                            id, Persona(
                                id,
                                nombresPersona,
                                apellidosPersona,
                                casa,
                                altura,
                                fechaNac,
                                tieneSeguro
                            )
                        )
                    ) {
                        println("Persona Actualizada")
                    } else {
                        println("Error al actualizar")
                    }
                }

            }

            ("3") -> {
                println("Seleccione la persona a eliminar")
                print(headerPersona)
                gestorPersona.verPersonas().forEach { print(it) }
                id = scanner.nextLine().toInt()
                if (gestorPersona.eliminarPersona(id)) {
                    println("Persona eliminada")
                } else {
                    println("Error al eliminar")
                }
            }

            else -> {
                activo = false
            }

        }
    }
}

fun menuCasa() {
    var opcion: String
    var activo = true
    var id: Int
    var idAsignacion = 0
    var direccion: String
    var superficie: Double
    var anioConstruccion: Int
    var pisos: Int
    var tienePatio: Boolean
    var costo: Int
    var aux: Int

    while (activo) {
        print(headerCasa)
        gestorCasa.verCasas().forEach { print(it) }
        println(
            "Seleccione la accion a realizar:\n" + "1. Añadir una casa\n" + "2. Actualizar una casa\n" + "3. Eliminar una casa\n" + "4. Ver las personas que habitan en una casa\n" + "5. Regresar"
        )
        opcion = scanner.nextLine()

        when (opcion) {
            ("1") -> {
                println("Ingrese la direccion de la casa: ")
                direccion = scanner.nextLine()
                println("Ingrese la superficie de la casa: ")
                superficie = scanner.nextLine().toDouble()
                println("Ingrese el año de construccio de la casa: ")
                anioConstruccion = scanner.nextLine().toInt()
                println("Ingrese cuantos pisos tiene la casa: ")
                pisos = scanner.nextLine().toInt()
                println("¿La casa tiene patio?\n1.Si\n2.No")
                aux = scanner.nextLine().toInt()
                tienePatio = aux == 1
                println("Ingrese el costo de la casa: ")
                costo = scanner.nextLine().toInt()
                if (gestorCasa.verCasas().isEmpty()) {
                    idAsignacion = 1
                } else {
                    if (gestorCasa.verCasas().last().getID() != null) {
                        idAsignacion = gestorCasa.verCasas().last().getID()!!.plus(1)
                    }
                }
                if (gestorCasa.crearCasa(
                        Casa(
                            idAsignacion, direccion, superficie, anioConstruccion, pisos, tienePatio, costo
                        )
                    )
                ) {

                    println("Casa creada exitosamente")
                } else {
                    println("Error al actualizar")
                }

            }

            ("2") -> {
                println("Seleccione el casa a actualizar (presione 0 para cancelar): ")
                print(headerCasa)
                gestorCasa.verCasas().forEach { print(it) }
                id = scanner.nextLine().toInt()
                if (id != 0) {
                    println("Ingrese la nueva dirección de la casa: ")
                    direccion = scanner.nextLine()
                    println("Ingrese la nueva superficie de la casa: ")
                    superficie = scanner.nextLine().toDouble()
                    println("Ingrese el nuevo año de construcción de la casa: ")
                    anioConstruccion = scanner.nextLine().toInt()
                    println("Ingrese la nueva cantidad de pisos que tiene la casa: ")
                    pisos = scanner.nextLine().toInt()
                    println("¿La casa tiene patio?\n1.Si\n2.No")
                    aux = scanner.nextLine().toInt()
                    tienePatio = aux == 1
                    println("Ingrese el nuevo costo de la casa: ")
                    costo = scanner.nextLine().toInt()
                    if (gestorCasa.actualizarCasa(
                            id, Casa(
                                id, direccion, superficie, anioConstruccion, pisos, tienePatio, costo
                            )
                        )
                    ) {

                        println("Casa actualizada exitosamente")
                    } else {
                        println("Error al actualizar")
                    }
                }
            }

            ("3") -> {
                println("Seleccione el casa a eliminar")
                print(headerCasa)
                gestorCasa.verCasas().forEach { print(it) }
                id = scanner.nextLine().toInt()
                if (gestorCasa.eliminarCasa(id)) {
                    println("Casa eliminado")
                } else {
                    println("Error al eliminar")
                }
            }

            ("4") -> {
                println("Seleccione la casa a visualizar")
                print(headerCasa)
                gestorCasa.verCasas().forEach { print(it) }
                id = scanner.nextLine().toInt()
                println("Las personas que habitan en esta casa son:")
                gestorPersona.bucarPersonasPorCasa(id).forEach {
                    print(it)
                }
            }

            else -> {
                activo = false
            }

        }
    }
}
