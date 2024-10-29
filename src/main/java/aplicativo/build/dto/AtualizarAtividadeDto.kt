package aplicativo.build.dto

import jakarta.persistence.Id
import java.time.LocalDate

data class AtualizarAtividadeDto(
    @Id
    val id: Long,
    val descAtividade: String,
    val dataInicio: LocalDate)
{

}