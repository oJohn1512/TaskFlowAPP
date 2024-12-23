package aplicativo.build.mapper

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.model.Atividade
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class AtividadesMapperImpl {

    fun toDtoCreate(entity: Atividade): CriarAtividadeDto {
        return CriarAtividadeDto(id = entity.id, descAtividade = entity.descAtividade, dataInicio = entity.dataInicio)
    }

    fun toEntityCreate(dto: CriarAtividadeDto): Atividade {
        return Atividade(id = dto.id, descAtividade = dto.descAtividade, dataInicio = dto.dataInicio)
    }

    fun toDtoUpdate(entity: Atividade): AtualizarAtividadeDto {
        return AtualizarAtividadeDto(
            id = entity.id,
            descAtividade = entity.descAtividade,
            dataInicio = entity.dataInicio
        )
    }

}



