package api.banda.borgone.service

import api.banda.borgone.dto.request.InstrumentRequest
import api.banda.borgone.dto.response.BasicResponse
import api.banda.borgone.dto.response.InstrumentResponse
import api.banda.borgone.entity.MusicalInstrument
import api.banda.borgone.exception.InstrumentNotFoundException
import api.banda.borgone.repository.InstrumentRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class InstrumentService(val instrumentRepo:InstrumentRepository) {

    //logic delete
    fun deleteInstrument(idInstrument:Long): ResponseEntity<BasicResponse>{
        val  instToDelete = instrumentRepo.findById(idInstrument).orElseThrow{ InstrumentNotFoundException("Instrument Not found with id {} $idInstrument")}
        instToDelete.active=false;
        instrumentRepo.save(instToDelete);
        return ResponseEntity(BasicResponse(status = true, message = "Instrument deleted successfully", body = null),HttpStatus.OK)
    }

    fun findById(idInstrument: Long) : ResponseEntity<BasicResponse>{
        val res = instrumentRepo.findByIdInstrumentAndActiveTrue(idInstrument).orElseThrow{InstrumentNotFoundException("Instrument Not found with id {} $idInstrument")}
        val list = ArrayList<InstrumentResponse>()
        list.add(InstrumentResponse( instrumentId= res.idInstrument?.toLong() ?: 0, instrumentKey = res.instrumentKey, instrumentName = res.instrumentName))
        return ResponseEntity(BasicResponse(status = true, message = "Instrument  found", body = list),HttpStatus.OK)
    }

    fun instrumentList(page:Int,number:Int) : ResponseEntity<BasicResponse>{
        val res = instrumentRepo.findAllByActive(true, PageRequest.of(page,number))
        val list = ArrayList<InstrumentResponse>()
        res.stream().forEach { ent-> list.add(InstrumentResponse(ent)) }
        return ResponseEntity(BasicResponse(status = true, message = "List Found successfully", body = list),HttpStatus.OK)
    }

    fun saveInstrument(request:InstrumentRequest) : ResponseEntity<BasicResponse>{
        instrumentRepo.save(MusicalInstrument(instrumentName = request.instrumentName, instrumentKey = request.instrumentKey, active = true))
        return ResponseEntity(BasicResponse(status = true, message = "Instrument saved successfully", body = null),HttpStatus.OK)
    }

}
