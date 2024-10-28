package aplicativo.build.dto

import jakarta.persistence.Id
import java.util.*

data class DeletarAtividadeDto(
    @Id
    val id: UUID = UUID.randomUUID(),
    val descAtividade: String)
{

}