package api.banda.borgone.controller

import api.banda.borgone.dto.request.MusicSheetRequest
import api.banda.borgone.dto.response.BasicResponse
import api.banda.borgone.exception.MusicSheetNotFoundException
import api.banda.borgone.service.MusicSheetService
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/composition")
@Validated
class MusicSheetController(val service:MusicSheetService) {

    @PostMapping("/new")
    @Operation(summary = "API that create a new composition in the organization")
    fun saveNew(@RequestBody @Valid request:MusicSheetRequest) : ResponseEntity<BasicResponse>{
        return service.saveSheet(request)
    }

    @DeleteMapping("/delete/{idSheet}")
    @Operation(summary = "API that remove a composition by ID in the organization")
    fun deleteSheet(@PathVariable @NotNull idSheet:Long) : ResponseEntity<BasicResponse> {
        try {
           return service.logicDelete(idSheet)
        }catch (e:MusicSheetNotFoundException){
            return ResponseEntity(BasicResponse(message = e.message.toString(), status = false, body = null),HttpStatus.NOT_FOUND)
        }
    }


}