package api.banda.borgone.controller

import api.banda.borgone.dto.request.InstrumentRequest
import api.banda.borgone.dto.request.MusicianRequest
import api.banda.borgone.dto.response.BasicResponse
import api.banda.borgone.service.MusicianService
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/musician")
@Validated
class MusicianController(val service:MusicianService) {

    private val logger: Logger = LoggerFactory.getLogger(MusicianController::class.java)

    @Operation(summary = "API that create a new musical instrument ")
    @PostMapping("/new")
    fun new(@RequestBody @Valid request: MusicianRequest): ResponseEntity<BasicResponse> {
        logger.info("Save new instrument {} ",request.toString())
        return service.saveMusician(request)
    }

}