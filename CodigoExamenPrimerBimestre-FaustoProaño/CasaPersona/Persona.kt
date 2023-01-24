import java.text.DecimalFormat
import java.time.LocalDate

class Persona(
    private var idPersona: Int? = null,
    private var nombresPersona: String? = null,
    private var apellidosPersona: String? = null,
    private var casa: Casa? = null,
    private var altura: Double? = null,
    private var fechaNacimiento: LocalDate? = null,
    private var tieneSeguro: Boolean? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Persona

        if (idPersona != other.idPersona) return false
        if (nombresPersona != other.nombresPersona) return false
        if (apellidosPersona != other.apellidosPersona) return false
        if (casa != other.casa) return false
        if (altura != other.altura) return false
        if (fechaNacimiento != other.fechaNacimiento) return false
        if (tieneSeguro != other.tieneSeguro) return false

        return true
    }

    override fun hashCode(): Int {
        var result = idPersona ?: 0
        result = 31 * result + (nombresPersona?.hashCode() ?: 0)
        result = 31 * result + (apellidosPersona?.hashCode() ?: 0)
        result = 31 * result + (casa?.hashCode() ?: 0)
        result = 31 * result + (altura?.hashCode() ?: 0)
        result = 31 * result + (fechaNacimiento?.hashCode() ?: 0)
        result = 31 * result + (tieneSeguro?.hashCode() ?: 0)

        return result
    }

    fun getID(): Int? {
        return idPersona
    }

    override fun toString(): String {

        val stringFechaNacimiento = String.format("%02d", fechaNacimiento?.dayOfMonth) +
                "/${String.format("%02d", fechaNacimiento?.monthValue)}" +
                "/${fechaNacimiento?.year}"
        var stringTieneSeguro = if (tieneSeguro != null) {
            if (tieneSeguro as Boolean) "Asegurado"
            else "No asegurado"
        } else "No asegurado"


        stringTieneSeguro= String.format("%-15s", stringTieneSeguro)
        val df = DecimalFormat("#.00")
        val stringAltura = df.format(altura)
        val stringCasa = casa?.getDireccion()
        val stringID = String.format("%02d", idPersona)
        val stringNombres = String.format("%-15s", nombresPersona)
        val stringApellidos = String.format("%-15s", apellidosPersona)
        return "${stringID}\t" +
                "${stringNombres}\t" +
                "${stringApellidos}\t\t" +
                "${stringAltura}\t\t" +
                "${stringFechaNacimiento}\t\t\t" +
                "${stringTieneSeguro}\t\t\t" +
                "${stringCasa}\n"

        /*
        return "${idPersona}\t" +
                "${nombresPersona}\t\t\t\t" +
                "${apellidosPersona}\t\t\t\t" +
                "${DecimalFormat("#.00").format(altura)}\t\t" +
                stringFechaNacimiento + "\t\t\t" +
                stringTieneSeguro + "\t\t\t" +
                "${casa?.getDireccion()}\n"

         */
    }

    fun toFile(): String {
        return "${idPersona}," +
                "${nombresPersona}," +
                "${apellidosPersona}," +
                "${casa?.getID()}," +
                "${altura}," +
                "${fechaNacimiento}," +
                "${tieneSeguro}\n"
    }

}
