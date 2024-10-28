package aplicativo.build.model

import jakarta.persistence.Entity
import java.time.LocalDate
import java.util.UUID

@Entity
class Atividade (val id: UUID, val descAtividade: String, val dataInicio: LocalDate) {


}