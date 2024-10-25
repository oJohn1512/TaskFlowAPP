package aplicativo.build.service.impl

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.dto.DeletarAtividadeDto
import aplicativo.build.mapper.AtividadesMapper
import aplicativo.build.services.AtividadesService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject



@ApplicationScoped
class AtividadesServiceImpl: AtividadesService {

    @Inject
    lateinit var mapper: AtividadesMapper


    override fun criarAtividade(descAtividade: CriarAtividadeDto, dataInicio: CriarAtividadeDto): CriarAtividadeDto{
        return mapper.createMapper(descAtividade, dataInicio)
    }

    override fun atualizarAtividade(descAtividade: AtualizarAtividadeDto, dataInicio: AtualizarAtividadeDto):Void{
        return mapper.updateMapper(descAtividade, dataInicio)
    }

    override fun deletarAtividade(id: DeletarAtividadeDto): DeletarAtividadeDto{
        return mapper.deleteMapper(id)
    }


}