package aplicativo.build.resource

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.service.AtividadesService
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

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
        return try {
        service.criarAtividade(atividade)
        return Response.ok().entity("Criado com sucesso!").build()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            Response.status(Response.Status.BAD_REQUEST).entity("Dados inválidos: ${e.message}").build()
        }
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

    @PUT
    @Path("/atribuiratividade/{idAtividade}/aoTecnico/{idTecnico}")
    fun atribuirAtividade(@PathParam("idAtividade") idAtividade: Long, @PathParam("idTecnico") idTecnico: Long): Response {
        service.atribuirAtividadeAoTecnico(idAtividade, idTecnico)
        return Response.ok().entity("Atribuido com sucesso!").build()
    }

}