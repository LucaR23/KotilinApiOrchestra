package api.banda.borgone.service

import api.banda.borgone.dto.request.MusicSheetRequest
import api.banda.borgone.dto.response.BasicResponse
import api.banda.borgone.entity.MusicSheet
import api.banda.borgone.exception.MusicSheetNotFoundException
import api.banda.borgone.repository.MusicSheetRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class MusicSheetService (val sheetRepo : MusicSheetRepository) {

    fun logicDelete(idSheet:Long) : ResponseEntity<BasicResponse>{
        var sheetToDelete = sheetRepo.findByIdAndActiveTrue(idSheet)
            .orElseThrow { MusicSheetNotFoundException("Sheet Not Found with Id:{} $idSheet") }
        sheetToDelete.active=false
        sheetRepo.save(sheetToDelete)
        return  ResponseEntity(BasicResponse(status = true, message = "Sheet deleted successfully", body = null),HttpStatus.OK)
    }

    fun saveSheet(request:MusicSheetRequest) : ResponseEntity<BasicResponse>{
       val ent= sheetRepo.save(MusicSheet(title = request.title, progressiveNumber = request.progressiveNumber,
            author = request.author, description = request.description, note = request.note, active = true))
        return  ResponseEntity(BasicResponse(status = true, message = "Sheet deleted successfully with id: {} ${ent.idMusicSheet}", body = null),HttpStatus.OK)
    }

}