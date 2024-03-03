package api.banda.borgone.service

import api.banda.borgone.dto.request.MusicianRequest
import api.banda.borgone.dto.response.BasicResponse
import api.banda.borgone.entity.MusicalInstrument
import api.banda.borgone.entity.Musician
import api.banda.borgone.entity.Role
import api.banda.borgone.exception.InstrumentNotFoundException
import api.banda.borgone.exception.RoleNotFoundException
import api.banda.borgone.repository.InstrumentRepository
import api.banda.borgone.repository.MusicianRepository
import api.banda.borgone.repository.RoleRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class MusicianService(val musicianRepo: MusicianRepository,
                      val roleRepository: RoleRepository,
                      val instrumentRepository: InstrumentRepository) {
    fun saveMusician(request: MusicianRequest) : ResponseEntity<BasicResponse> {
        musicianRepo.save(fromRequestToEntity(request))
        return ResponseEntity(
            BasicResponse(status = true, message = "Musician saved successfully", body = null),
            HttpStatus.CREATED)
    }





/**private fun */
   private fun fromRequestToEntity(request: MusicianRequest) : Musician{
     return   Musician(idRole =validateRole(request.idRole),
            name = request.name,
            surname = request.surname,
            birthDate = request.birthDate,
            taxIdCode = request.taxIdCode,
            phoneNumber = request.phoneNumber,
            email = request.email,
            idInstrument = validateInstrument(request.idInstrument),
            identificationDocument = request.identificationDocument,
            startYear = request.startYear,
            active = true,
            tessarate = request.tessarate
            )
    }

    private fun validateInstrument(idInstrument: Long): MusicalInstrument{
        return instrumentRepository.findByIdInstrumentAndActiveTrue(idInstrument)
            .orElseThrow{ InstrumentNotFoundException("Instrument Not found with id {} $idInstrument") }

    }
    private fun validateRole(idRole : Long) : Role {
        return  roleRepository.findByIdRoleAndActiveTrue(idRole)
            .orElseThrow{RoleNotFoundException("Role not found with Id {} $idRole")}
    }

}