package aplicativo.build.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
class Atividade (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var descAtividade: String,
    var dataInicio: LocalDate) {


}