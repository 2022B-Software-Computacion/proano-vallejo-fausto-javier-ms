import java.time.LocalDate
import java.util.*

class Casa(
    private var idCasa: Int? = null,
    private var direccion: String? = null,
    private var superficie: Double? = null,
    private var anioConstruccion: Int? = null,
    private var pisos: Int? = null,
    private var tienePatio: Boolean? = null,
    private var costo: Int? = null,
) {

    override fun toString(): String {

        //aligned table


        return "${idCasa}\t" +
                "${superficie}\t\t\t" +
                "${anioConstruccion}\t\t" +
                "${pisos}\t\t\t" +
                "${if (tienePatio == true) "Con patio" else "Sin patio"}\t\t\t" +
                "${costo}\t\t"+
                "${direccion}\n"
    }

    fun toFile(): String {
        return "${idCasa}," +
                "${direccion}," +
                "${superficie}," +
                "${anioConstruccion}," +
                "${pisos}," +
                "${tienePatio}," +
                "$costo"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Casa

        if (idCasa != other.idCasa) return false
        if (direccion != other.direccion) return false
        if (superficie != other.superficie) return false
        if (anioConstruccion != other.anioConstruccion) return false
        if (pisos != other.pisos) return false
        if (tienePatio != other.tienePatio) return false
        if (costo != other.costo) return false

        return true
    }

    override fun hashCode(): Int {
        var result = idCasa ?: 0
        result = 31 * result + (direccion?.hashCode() ?: 0)
        result = 31 * result + (superficie?.hashCode() ?: 0)
        result = 31 * result + (anioConstruccion ?: 0)
        result = 31 * result + (pisos ?: 0)
        result = 31 * result + (tienePatio?.hashCode() ?: 0)
        result = 31 * result + (costo ?: 0)

        return result
    }

    fun getID(): Int? {
        return idCasa
    }

    fun getDireccion(): String? {
        return direccion
    }

}
