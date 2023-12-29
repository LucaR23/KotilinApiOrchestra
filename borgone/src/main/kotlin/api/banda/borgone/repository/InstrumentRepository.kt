package api.banda.borgone.repository

import api.banda.borgone.entity.MusicalInstrument
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface InstrumentRepository : JpaRepository<MusicalInstrument, Long> {
    fun findAllByActive(active:Boolean,page:Pageable) : Page<MusicalInstrument>

    fun findByIdInstrumentAndActiveTrue(idInstrument:Long) : Optional<MusicalInstrument>

    @Query(
        value = "SELECT m FROM  MusicalInstrument m WHERE m.instrumentName LIKE CONCAT('%', :param, '%' ) AND m.active=true",
        countQuery ="SELECT COUNT(*) FROM  MusicalInstrument m WHERE m.instrumentName LIKE CONCAT('%', :param, '%' )  AND m.active=true",
    )
    fun findByParam(page: Pageable,param:String) : Page<MusicalInstrument>
}