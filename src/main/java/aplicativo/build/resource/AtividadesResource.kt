package aplicativo.build.resource

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.dto.DeletarAtividadeDto
import aplicativo.build.mapper.AtividadesMapper
import aplicativo.build.model.Atividade
import aplicativo.build.services.AtividadesService
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import java.time.LocalDate

@Path("/atividades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class AtividadesResource {

    @Inject
    lateinit var service: AtividadesService

    @GET
    @Path("/listaAtividades")
    fun listarAtividades(): Response{
        var lista = service.listaAtividades()
        return Response.ok().entity(arrayOf(lista)).build()
    }

    @POST
    @Path("/criarAtividade")
    fun criarAtividade(atividade: CriarAtividadeDto): Response{
        service.criarAtividade(atividade)
        return Response.ok().entity("Criado com sucesso!").build()
    }

    @PUT
    @Path("/atualizarAtividade/{id}")
    fun atualizarAtividade(@PathParam("id") id: Long, attAtividade: AtualizarAtividadeDto): Response{
        service.atualizarAtividade(id, attAtividade)
        return Response.ok().entity(attAtividade).build()
    }

    @DELETE
    @Path("/deletarAtividade/{id}")
    fun deletarAtividade(@PathParam("id") id:Long): Response{
        service.deletarAtividade(id)
        return Response.ok().entity("Deletado com sucesso").build()
    }



}