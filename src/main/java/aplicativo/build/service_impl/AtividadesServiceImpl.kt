package aplicativo.build.service_impl

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.mapper.AtividadesMapperImpl
import aplicativo.build.model.Atividade
import aplicativo.build.model.Tecnico
import aplicativo.build.repository.AtividadesRepository
import aplicativo.build.repository.TecnicoRepository
import aplicativo.build.service.AtividadesService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.NotFoundException


@ApplicationScoped
class AtividadesServiceImpl: AtividadesService {

    @Inject
    lateinit var mapper: AtividadesMapperImpl
    @Inject
    lateinit var repositoryAtividade: AtividadesRepository
    @Inject
    lateinit var repositoryTecnico: TecnicoRepository


    override fun listaAtividades(): List<Atividade> {
        return try {
            repositoryAtividade.listAll()
        } catch (e: Exception) {
            e.printStackTrace()
            println("Erro ao listar atividades")
            emptyList()
        }
    }

    @Transactional
    override fun criarAtividade(dadosAtividade: CriarAtividadeDto): CriarAtividadeDto{
        try {
        val atividadeEntity = mapper.toEntityCreate(dadosAtividade)
        repositoryAtividade.persist(atividadeEntity)
        return mapper.toDtoCreate(atividadeEntity)
        } catch (e: Exception) {
            e.printStackTrace()
            println("Atividade não encontrada")
        }
        return dadosAtividade
    }

    @Transactional
    override fun atualizarAtividade(idPraAtualizar: Long, attAtividade: AtualizarAtividadeDto): AtualizarAtividadeDto {
        if (repositoryAtividade.findById(idPraAtualizar) == null) {
            throw NotFoundException("Atividade não encontrada")
        }
            try {val atividadeExistente = repositoryAtividade.findById(idPraAtualizar)
            atividadeExistente.descAtividade = attAtividade.descAtividade
            atividadeExistente.dataInicio = attAtividade.dataInicio
            repositoryAtividade.persist(atividadeExistente)
            return mapper.toDtoUpdate(atividadeExistente)
            } catch (e: Exception){
            e.printStackTrace()
            println("Erro na hora de atualizar Atividade")
            }
        return attAtividade
    }

    @Transactional
    override fun deletarAtividade(idPraDeletar: Long) {
        try {
            if (repositoryAtividade.findById(idPraDeletar) != null) {
                repositoryAtividade.deleteById(idPraDeletar)
            } else {
                throw NotFoundException("Atividade não encontrada")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            println("Erro ao deletar atividade")
        }
    }

    @Transactional
    override fun atribuirAtividadeAoTecnico(idAtividade:Long, idTecnico: Long){
        val atividade =  repositoryAtividade.findById(idAtividade)
        val tecnico =  repositoryTecnico.findById(idTecnico)
        atividade.tecnico = tecnico
        tecnico.atividadesTenico.add(atividade)
    }
}