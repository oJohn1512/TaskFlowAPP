package aplicativo.build.service_impl

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.mapper.AtividadesMapperImpl
import aplicativo.build.model.Atividade
import aplicativo.build.repository.AtividadesRepository
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
    lateinit var repository: AtividadesRepository


    override fun listaAtividades(): List<Atividade> {
        return repository.listAll()
    }

    @Transactional
    override fun criarAtividade(descAtividadeDto: CriarAtividadeDto): CriarAtividadeDto{
        val atividadeEntity = mapper.toEntityCreate(descAtividadeDto)
        repository.persist(atividadeEntity)
        return mapper.toDtoCreate(atividadeEntity)
    }

    @Transactional
    override fun atualizarAtividade(idPraAtualizar: Long, attAtividade: AtualizarAtividadeDto): AtualizarAtividadeDto {
        if (repository.findById(idPraAtualizar) == null) {
            throw NotFoundException("Atividade não encontrada")
        }
            val atividadeExistente = repository.findById(idPraAtualizar)
            atividadeExistente.descAtividade = attAtividade.descAtividade
            atividadeExistente.dataInicio = attAtividade.dataInicio
            repository.persist(atividadeExistente)
            return mapper.toDtoUpdate(atividadeExistente)
//        } catch (e: Exception){
//            e.printStackTrace()
//            println("Erro na hora de atualizar Atividade")
//        }
    }


    @Transactional
    override fun deletarAtividade(idPraDeletar: Long) {
        if(repository.findById(idPraDeletar) != null)
            repository.deleteById(idPraDeletar)
        else {
            println("Atividade não encontrada na base")
        }
    }

}