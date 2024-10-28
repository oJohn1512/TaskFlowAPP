package aplicativo.build.dto

import jakarta.persistence.Id
import java.time.LocalDate
import java.util.*

data class AtualizarAtividadeDto (
    @Id
    val id: UUID,
    val descAtividade: String,
    val dataInicio: LocalDate)
{

}