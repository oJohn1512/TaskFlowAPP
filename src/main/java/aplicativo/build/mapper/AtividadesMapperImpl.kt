package aplicativo.build.mapper

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.dto.DeletarAtividadeDto
import aplicativo.build.model.Atividade
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class AtividadesMapperImpl: AtividadesMapper {

    override fun toDtoCreate(entity: Atividade): CriarAtividadeDto {
        return CriarAtividadeDto(id = entity.id, descAtividade = entity.descAtividade, dataInicio = entity.dataInicio)
    }

    override fun toEntityCreate(dto: CriarAtividadeDto): Atividade {
        return Atividade(id = dto.id, descAtividade = dto.descAtividade, dataInicio = dto.dataInicio)
    }

    override fun toDtoUpdate(entity: Atividade): AtualizarAtividadeDto {
        return AtualizarAtividadeDto(
            id = entity.id,
            descAtividade = entity.descAtividade,
            dataInicio = entity.dataInicio
        )
    }

    override fun toDtoDelete(entity: Atividade): DeletarAtividadeDto {
        return DeletarAtividadeDto(id = entity.id, descAtividadeDto = entity.descAtividade, dataInicio = entity.dataInicio)
    }

    override fun toEntityDelete(dto:DeletarAtividadeDto): Atividade {
        return Atividade(id = dto.id, descAtividade = dto.descAtividadeDto, dataInicio = dto.dataInicio)
    }
}

//    override fun toEntityDelete(dto: DeletarAtividadeDto): Atividade {
   //     return Atividade(id = dto.id, descAtividade = dto.descAtividade, ) //CONSTRUIR SEGUNDO CONSTRUTOR NO ATIVVIDADE
    //}


