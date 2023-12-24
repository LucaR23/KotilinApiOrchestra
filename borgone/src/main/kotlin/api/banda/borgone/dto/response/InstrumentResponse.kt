package api.banda.borgone.dto.response

import api.banda.borgone.entity.MusicalInstrument

class InstrumentResponse {
    private var instrumentId:Long? = null
    private var instrumentName:String= ""
    private var instrumentKey:String= ""

    constructor(entity: MusicalInstrument){
        this.instrumentId=entity.idInstrument
        this.instrumentKey= entity.instrumentKey
        this.instrumentName=entity.instrumentName
    }

    constructor(instrumentId:Long,instrumentName:String,instrumentKey:String){
        this.instrumentId=instrumentId
        this.instrumentKey= instrumentKey
        this.instrumentName=instrumentName
    }
}