package aplicativo.build.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import java.time.LocalDate

@Entity
class Atividade (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var descAtividade: String,
    var dataInicio: LocalDate)
{

    var tecnico: Tecnico? = null
    constructor() :this (0, "", LocalDate.now())
}