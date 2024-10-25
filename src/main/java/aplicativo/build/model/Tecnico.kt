package aplicativo.build.model

import jakarta.persistence.Entity
import java.util.UUID

@Entity
class Tecnico (val id: UUID, val nomeTecnico: String, val setor: String,) {
    val atividade: MutableList<Atividade> = mutableListOf()
}