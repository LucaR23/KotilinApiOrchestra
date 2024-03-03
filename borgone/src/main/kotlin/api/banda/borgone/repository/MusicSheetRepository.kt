package api.banda.borgone.repository

import api.banda.borgone.entity.MusicSheet
import api.banda.borgone.entity.MusicalInstrument
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface MusicSheetRepository :  JpaRepository<MusicSheet, Long> {

    fun findByIdMusicSheetAndActiveTrue(idSheet:Long) : Optional<MusicSheet>

    fun findAllByActive(active:Boolean,page: Pageable) : Page<MusicSheet>


    @Query(
        value = "SELECT s FROM MusicSheet s WHERE s.active=true AND ( s.author  LIKE CONCAT('%', :param, '%' ) OR  s.title  LIKE CONCAT('%', :param, '%' )  ) ",
        countQuery = "SELECT COUNT(*) FROM MusicSheet s WHERE s.active=true AND ( s.author  LIKE CONCAT('%', :param, '%' ) OR  s.title  LIKE CONCAT('%', :param, '%' )  ) "
    )
    fun researchSheet(param:String,page : Pageable) : Page<MusicSheet>
}