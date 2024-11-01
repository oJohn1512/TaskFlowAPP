package aplicativo.build.mapper

import aplicativo.build.dto.AtualizarCadastroTecnicoDto
import aplicativo.build.dto.CadastrarTecnicoDto

import aplicativo.build.model.Tecnico
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class TecnicoMapperImpl {

    fun toEntityCadastrarTecnico(dto: CadastrarTecnicoDto): Tecnico {
        return Tecnico(id = dto.id, nomeTecnico = dto.nomeTecnico, setor = dto.setor)
    }

    fun toDtoCadastrarTecnico(entity: Tecnico): CadastrarTecnicoDto {
        return CadastrarTecnicoDto(id =entity.id, nomeTecnico = entity.nomeTecnico, setor = entity.setor)
    }

    fun toEntityAtualizarTecnico(dto: AtualizarCadastroTecnicoDto): Tecnico {
        return Tecnico(id = dto.id, nomeTecnico = dto.nomeTecnico, setor = dto.setor)
    }

    fun toDtoAtualizarTecnico(entity: Tecnico): AtualizarCadastroTecnicoDto {
        return AtualizarCadastroTecnicoDto(id =entity.id, nomeTecnico = entity.nomeTecnico, setor = entity.setor)
    }
}