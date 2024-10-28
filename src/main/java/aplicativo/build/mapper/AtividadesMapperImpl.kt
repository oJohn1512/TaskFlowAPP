package aplicativo.build.mapper

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.dto.DeletarAtividadeDto
import aplicativo.build.model.Atividade

class AtividadesMapperImpl: AtividadesMapper {

    override fun toDtoCreate(entity: Atividade): CriarAtividadeDto {
        return CriarAtividadeDto(id = entity.id, descAtividade = entity.descAtividade, dataInicio = entity.dataInicio)
    }

    override fun toEntityCreate(dto: CriarAtividadeDto): Atividade {
        return Atividade(id = dto.id, descAtividade = dto.descAtividade, dataInicio = dto.dataInicio)
    }

    override fun toDtoUpdate(entity: Atividade): AtualizarAtividadeDto {
        return AtualizarAtividadeDto(id = entity.id, descAtividade = entity.descAtividade, dataInicio = entity.dataInicio)
    }

    override fun toEntityUpdate(dto: AtualizarAtividadeDto): Atividade {
        return Atividade(id = dto.id, descAtividade = dto.descAtividade, dataInicio = dto.dataInicio)
    }

    override fun toDtoDelete(entity: Atividade): DeletarAtividadeDto {
        return DeletarAtividadeDto(id = entity.id, descAtividade = entity.descAtividade)
    }

    override fun toEntityDelete(dto: DeletarAtividadeDto): Atividade {
        return Atividade(id = dto.id, descAtividade = dto.descAtividade, ) //CONSTRUIR SEGUNDO CONSTRUTOR NO ATIVVIDADE
    }


}