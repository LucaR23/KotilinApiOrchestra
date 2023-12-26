package api.banda.borgone.dto.request

import api.banda.borgone.dto.response.InstrumentResponse
import api.banda.borgone.entity.MusicalInstrument
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class InstrumentRequest(
    @NotBlank @Size(min = 2)
    val instrumentName: String,
    @NotBlank @Size(min = 1)
    val instrumentKey: String,
)