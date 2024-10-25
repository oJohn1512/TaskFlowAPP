package aplicativo.build.dto

import jakarta.persistence.Id
import java.time.LocalDate
import java.util.*

data class CriarAtividadeDto (
    @Id
    val id: UUID = UUID.randomUUID(),
    val descAtividade: String,
    val dataInicio: LocalDate)
{

}
