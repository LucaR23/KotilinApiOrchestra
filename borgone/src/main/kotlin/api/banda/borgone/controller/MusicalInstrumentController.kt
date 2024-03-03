package api.banda.borgone.controller

import api.banda.borgone.dto.request.InstrumentRequest
import api.banda.borgone.dto.response.BasicResponse
import api.banda.borgone.exception.InstrumentNotFoundException
import api.banda.borgone.service.InstrumentService
import io.klogging.NoCoLogger
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/instrument")
@Validated
class MusicalInstrumentController(private val service: InstrumentService) {

    private val logger: Logger = LoggerFactory.getLogger(MusicalInstrumentController::class.java)


    @Operation(summary = "API that create a new musical instrument ")
    @PostMapping("/new")
    fun new(@RequestBody @Valid request:InstrumentRequest): ResponseEntity<BasicResponse> {
        logger.info("Save new instrument {} ",request.toString())
        return service.saveInstrument(request)
    }
    @Operation(summary = "API to remove an instrument from the list")
    @DeleteMapping("/delete/{idInstrument}")
    fun delete(@PathVariable @NotNull @Min(1) idInstrument:Long) : ResponseEntity<BasicResponse>{
        try {
            logger.info("Delete instrument {} ",idInstrument)
            return service.deleteInstrument(idInstrument)
        }catch (e:InstrumentNotFoundException){
            logger.error("Error during delete : {} ",e)
            return ResponseEntity(BasicResponse(status = false, message = e.message.toString(), body = null)
                ,HttpStatus.NOT_FOUND)
        }
    }
    @Operation(summary = "API to get  an instrument by is ID")
    @GetMapping("/get/{idInstrument}")
    fun findById(@PathVariable @NotNull @Min(1) idInstrument:Long) : ResponseEntity<BasicResponse>{
        try {
            return service.findById(idInstrument)
        }catch (e:InstrumentNotFoundException){
            logger.error("Error during find instrument with DI {}", idInstrument)
            return ResponseEntity(BasicResponse(status = false, message = e.message.toString(), body = null)
                ,HttpStatus.NOT_FOUND)
        }
    }
    @Operation(summary = "API to get the list of instrument")
    @GetMapping("/list/")
    fun instrumentList(@RequestParam @Min(0) page:Int,@RequestParam @Min(1) num:Int) : ResponseEntity<BasicResponse>{
        return service.instrumentList(page,num)
    }
    @Operation(summary = "API to get the list of instrument filtered by parameter")
    @GetMapping("/research/")
    fun researchInstrument(@RequestParam @Min(0) page:Int,@RequestParam @Min(1) num:Int,@RequestParam param:String) : ResponseEntity<BasicResponse> {
        return service.researchInstrument(page,num,param)
    }

}