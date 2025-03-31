package me.felipedev.email.controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/test")
@Tag(name = "Test Controller", description = "Endpoints para teste de integridade da API")
public class testController {


    @Operation(summary = "Teste de Integridade (GET)", description = "Verifica se a API está funcionando corretamente.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "API operacional")
    })
    @CrossOrigin
    @GetMapping("/getstatusapp")
    public String getStatusApp() {
        return "{\"status\":\"up\"}";
    }


    @Operation(summary = "Teste de Integridade (POST)", description = "Executa um teste de integridade enviando uma requisição POST.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "API operacional")
    })
    @CrossOrigin
    @PostMapping("/poststatusapp")
    public String postStatusApp() {
        return "{\"status\":\"up\"}";
    }
}
