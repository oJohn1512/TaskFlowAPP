package aplicativo.build.mapper


import aplicativo.build.dto.AtualizarCadastroTecnicoDto
import aplicativo.build.dto.CadastrarTecnicoDto
import aplicativo.build.dto.DeletarCadastroTecnicoDto
import aplicativo.build.model.Tecnico


interface TecnicoMapper {

    fun toEntityCadastrarTecnico(dto:CadastrarTecnicoDto):Tecnico
    fun toDtoCadastrarTecnico(entity: Tecnico):CadastrarTecnicoDto

    fun toEntityAtualizarTecnico(dto: AtualizarCadastroTecnicoDto): Tecnico
    fun toDtoAtualizarTecnico(entity: Tecnico): AtualizarCadastroTecnicoDto

    fun toEntityDeletarTecnico(dto:DeletarCadastroTecnicoDto):Tecnico
}