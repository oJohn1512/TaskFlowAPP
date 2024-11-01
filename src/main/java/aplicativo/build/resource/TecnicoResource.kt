package aplicativo.build.resource

import aplicativo.build.dto.AtualizarCadastroTecnicoDto
import aplicativo.build.dto.CadastrarTecnicoDto
import aplicativo.build.service.TecnicoService
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/tecnico")
class TecnicoResource {

    @Inject
    lateinit var service: TecnicoService

    @GET
    @Path("/listaTecnicos")
    fun listaTecnicos(): Response{
        val lista = service.listTecnicos()
        return Response.ok().entity(arrayOf(lista)).build()
    }

    @POST
    @Path("/cadastrarTecnico")
    fun criarTecnico(novoTecnico: CadastrarTecnicoDto): Response{
        service.criaTecnico(novoTecnico)
        return Response.ok().entity("Tecnico cadastrado com sucesso!").build()
    }

    @PUT
    @Path("/atualizarTecnico/{id}")
    fun atualizarTecnico(@PathParam("id") id:Long, tecnicoParaAtualizar:AtualizarCadastroTecnicoDto): Response{
        service.atualizarTecnico(id, tecnicoParaAtualizar)
        return Response.ok().entity("Infos do tecnico atualizadas!").build()
    }

    @DELETE
    @Path("/deletarTecnico/{id}")
    fun deletarTecnico(@PathParam("id") idTecnico: Long): Response{
        service.deletarTecnico(idTecnico)
        return Response.ok().entity("Tecnico excluido da Lista").build()
    }

}