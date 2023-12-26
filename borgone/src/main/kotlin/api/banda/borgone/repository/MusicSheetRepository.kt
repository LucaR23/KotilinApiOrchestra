package api.banda.borgone.repository

import api.banda.borgone.entity.MusicSheet
import api.banda.borgone.entity.MusicalInstrument
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MusicSheetRepository: JpaRepository<MusicSheet, Long> {

    fun findByIdAndActiveTrue(idSheet:Long) : Optional<MusicSheet>
}