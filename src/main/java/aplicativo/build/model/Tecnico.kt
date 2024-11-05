package aplicativo.build.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
class Tecnico (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var nomeTecnico: String,
    var setor: String,)
{
    val atividadesTenico: MutableList<Atividade> = mutableListOf()

    constructor() :this (0, "", "")
}

