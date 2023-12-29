package api.banda.borgone.service

import api.banda.borgone.dto.request.MusicSheetRequest
import api.banda.borgone.dto.response.BasicResponse
import api.banda.borgone.dto.response.InstrumentResponse
import api.banda.borgone.dto.response.MusicSheetResponse
import api.banda.borgone.entity.MusicSheet
import api.banda.borgone.exception.MusicSheetNotFoundException
import api.banda.borgone.repository.MusicSheetRepository
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class MusicSheetService (val sheetRepo : MusicSheetRepository) {

    fun logicDelete(idSheet:Long) : ResponseEntity<BasicResponse>{
        var sheetToDelete = sheetRepo.findByIdMusicSheetAndActiveTrue(idSheet)
            .orElseThrow { MusicSheetNotFoundException("Sheet Not Found with Id:{} $idSheet") }
        sheetToDelete.active=false
        sheetRepo.save(sheetToDelete)
        return  ResponseEntity(BasicResponse(status = true, message = "Sheet deleted successfully", body = null),HttpStatus.OK)
    }

    fun saveSheet(request:MusicSheetRequest) : ResponseEntity<BasicResponse>{
       val ent= sheetRepo.save(MusicSheet(title = request.title, progressiveNumber = request.progressiveNumber,
            author = request.author, description = request.description, note = request.note, active = true))
        return  ResponseEntity(BasicResponse(status = true, message = "Sheet saved successfully with id:  ${ent.idMusicSheet}", body = null),HttpStatus.OK)
    }

    fun sheetList(page:Int,number:Int) : ResponseEntity<BasicResponse>{
        val ent = sheetRepo.findAllByActive(true,PageRequest.of(page,number))
        val list = ArrayList<MusicSheetResponse>()
        ent.stream().forEach {item->list.add(getDtoObject(item)) }
        return ResponseEntity(BasicResponse(status = true, message = "List found successfully",body=list),HttpStatus.OK)
    }

    fun getSheetById(idSheet:Long) : ResponseEntity<BasicResponse>{
        val ent = sheetRepo.findByIdMusicSheetAndActiveTrue(idSheet).orElseThrow { MusicSheetNotFoundException("Sheet not found with ID {} $idSheet") }
        val list = ArrayList<MusicSheetResponse>()
        list.add(getDtoObject(ent))
        return ResponseEntity(BasicResponse(status = true, message = "Music Sheet found successfully", body =list),HttpStatus.OK)
    }

    fun editSheet(idSheet:Long, request:MusicSheetRequest) : ResponseEntity<BasicResponse> {
        val ent = sheetRepo.findByIdMusicSheetAndActiveTrue(idSheet).orElseThrow { MusicSheetNotFoundException("Sheet not found with ID {} $idSheet") }
        ent.author= request.author
        ent.description= request.description
        ent.note= request.note
        ent.progressiveNumber= request.progressiveNumber
        ent.title=request.title
        sheetRepo.save(ent)
        return  ResponseEntity(BasicResponse(status = true, message = "Sheet saved successfully with id:  ${ent.idMusicSheet}", body = null),HttpStatus.OK)
    }

    fun researchSheet(page:Int,number:Int,param:String) : ResponseEntity<BasicResponse>{
        val entList = sheetRepo.researchSheet(param,PageRequest.of(page,number))
        val list = ArrayList<MusicSheetResponse>()
        entList.stream().forEach {item->list.add(getDtoObject(item)) }
        return ResponseEntity(BasicResponse(status = true, message = "List found successfully",body=list),HttpStatus.OK)
    }

    fun getDtoObject(ent:MusicSheet) : MusicSheetResponse {
        return MusicSheetResponse(
            active = ent.active,
            author = ent.author,
            idMusicSheet =  ent.idMusicSheet!!.toLong(),
            description = ent.description,
            note = ent.note,
            progressiveNumber = ent.progressiveNumber,
            title =  ent.title
        )
    }
}