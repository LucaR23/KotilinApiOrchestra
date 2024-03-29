package api.banda.borgone.controller

import api.banda.borgone.dto.request.MusicSheetRequest
import api.banda.borgone.dto.response.BasicResponse
import api.banda.borgone.exception.MusicSheetNotFoundException
import api.banda.borgone.service.MusicSheetService
import io.klogging.logger
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import kotlin.math.log

@RestController
@RequestMapping("api/composition")
@Validated
class MusicSheetController(val service:MusicSheetService) {

    private val logger: Logger = LoggerFactory.getLogger(MusicSheetController::class.java)

    @PostMapping("/new")
    @Operation(summary = "API that create a new composition in the organization")
    fun saveNew(@RequestBody @Valid request:MusicSheetRequest) : ResponseEntity<BasicResponse>{
        logger.info("Save new music sheet {}",request.toString())
        return service.saveSheet(request)
    }

    @DeleteMapping("/delete/{idSheet}")
    @Operation(summary = "API that remove a composition by ID in the organization")
    fun deleteSheet(@PathVariable @NotNull idSheet:Long) : ResponseEntity<BasicResponse> {
        try {
            logger.info("Deleting music sheet ID {]",idSheet)
           return service.logicDelete(idSheet)
        }catch (e:MusicSheetNotFoundException){
            logger.error("Error during deleting musicSheet {} ",idSheet)
            return ResponseEntity(BasicResponse(message = e.message.toString(), status = false, body = null),HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/list/")
    @Operation(summary = "API to get the list of composition in the organization")
    fun getSheetList(@RequestParam page:Int,  @RequestParam number:Int) : ResponseEntity<BasicResponse>{
        return service.sheetList(page,number)
    }
    @GetMapping("/get/{idSheet}")
    @Operation(summary = "API to get the a composition  by his ID in the organization")
    fun getById(@PathVariable idSheet:Long) : ResponseEntity<BasicResponse>{
        try{
            return service.getSheetById(idSheet)
        }catch (e: MusicSheetNotFoundException){
            logger.error("Error during finding musicSheet {} ",idSheet)
            return ResponseEntity(BasicResponse(message = e.message.toString(), status = false, body = null),HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/edit/{idSheet}")
    @Operation(summary = "API to get the a composition  by his ID in the organization")
    fun editMusicSheet(@PathVariable idSheet:Long, @RequestBody request:MusicSheetRequest) : ResponseEntity<BasicResponse>{
        try{
            return service.editSheet(idSheet,request)
        }catch (e: MusicSheetNotFoundException){
            logger.error("Error during editing musicSheet {} ",idSheet)
            return ResponseEntity(BasicResponse(message = e.message.toString(), status = false, body = null),HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/research/")
    @Operation(summary = "API to get the list of composition in the organization filtered by param")
    fun researchSheet(@RequestParam page:Int,  @RequestParam number:Int, @RequestParam param:String) : ResponseEntity<BasicResponse>{
        return  service.researchSheet(page,number,param)
    }


}