package api.banda.borgone.dto.request

import api.banda.borgone.dto.response.InstrumentResponse
import api.banda.borgone.entity.MusicalInstrument

data class InstrumentRequest (
    val instrumentName:String ,val instrumentKey:String

)