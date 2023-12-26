package api.banda.borgone.dto.response

import api.banda.borgone.entity.MusicalInstrument

  class InstrumentResponse {
     var instrumentId:Long?=null
      var instrumentName:String?=""
      var instrumentKey:String?=""

     constructor(entity: MusicalInstrument){
        instrumentId=entity.idInstrument
        instrumentKey= entity.instrumentKey
        instrumentName=entity.instrumentName
    }

    constructor(instrumentId:Long,instrumentName:String,instrumentKey:String){
        this.instrumentId=instrumentId
        this.instrumentKey= instrumentKey
        this.instrumentName=instrumentName
    }
}