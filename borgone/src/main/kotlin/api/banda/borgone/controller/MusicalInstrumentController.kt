package api.banda.borgone.controller

import api.banda.borgone.service.InstrumentService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/instrument")
@Validated
class MusicalInstrumentController(private val service: InstrumentService) {


}