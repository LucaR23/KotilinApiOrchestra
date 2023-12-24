package api.banda.borgone.repository

import api.banda.borgone.entity.MusicalInstrument
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface InstrumentRepository : JpaRepository<MusicalInstrument, Long> {
    fun findAllByActive(active:Boolean,page:Pageable) : Page<MusicalInstrument>

    fun findByIdAndActiveTrue(idInstrument:Long) : Optional<MusicalInstrument>
}