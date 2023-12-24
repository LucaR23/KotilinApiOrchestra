package api.banda.borgone.controller

import api.banda.borgone.dto.request.InstrumentRequest
import api.banda.borgone.dto.response.BasicResponse
import api.banda.borgone.exception.InstrumentNotFoundException
import api.banda.borgone.service.InstrumentService
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/instrument")
@Validated
class MusicalInstrumentController(private val service: InstrumentService) {

    @Operation(summary = "API that create a new musical instrument ")
    @PostMapping("/new")
    fun new(@RequestBody @Valid request:InstrumentRequest): ResponseEntity<BasicResponse> {
        return service.saveInstrument(request);
    }
    @Operation(summary = "API to remove an instrument from the list")
    @DeleteMapping("/delete/{idInstrument}")
    fun delete(@PathVariable @NotNull @Min(1) idInstrument:Long) : ResponseEntity<BasicResponse>{
        try {
            return service.deleteInstrument(idInstrument);
        }catch (e:InstrumentNotFoundException){
            return ResponseEntity(BasicResponse(status = false, message = e.message.toString(), body = null)
                ,HttpStatus.NOT_FOUND)
        }
    }
    @Operation(summary = "API to get  an instrument by is ID")
    @GetMapping("/get/{idInstrument}")
    fun findById(@PathVariable @NotNull @Min(1) idInstrument:Long) : ResponseEntity<BasicResponse>{
        try {
            return service.findById(idInstrument);
        }catch (e:InstrumentNotFoundException){
            return ResponseEntity(BasicResponse(status = false, message = e.message.toString(), body = null)
                ,HttpStatus.NOT_FOUND)
        }
    }

    @Operation(summary = "API to get the list of instrument")
    @GetMapping("/list/")
    fun instrumentList(@RequestParam @Min(0) page:Int,@RequestParam @Min(1) num:Int) : ResponseEntity<BasicResponse>{
        return service.instrumentList(page,num);
    }


}