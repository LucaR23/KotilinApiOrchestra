package api.banda.borgone.dto.request

import api.banda.borgone.entity.MusicalInstrument
import api.banda.borgone.entity.Role
import jakarta.persistence.Column
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

data class MusicianRequest (
    val idRole: Long,
    val name:String,
    @NotBlank @Size(min = 1)
    val surname:String,
    val birthDate: LocalDate,
    @NotBlank @Size(min=12 , max = 16)
    val taxIdCode:String,   // codice fiscale IT
    val phoneNumber:String,
    @Email
    val email:String,
    val idInstrument: Long,
    val identificationDocument:String,
    val startYear:String,
    val active:Boolean,
    val tessarate:Boolean,
)