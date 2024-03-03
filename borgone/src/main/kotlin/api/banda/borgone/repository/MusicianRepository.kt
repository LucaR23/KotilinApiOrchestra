package api.banda.borgone.repository

import api.banda.borgone.entity.Musician
import org.springframework.data.jpa.repository.JpaRepository

interface MusicianRepository : JpaRepository<Musician, Long> {

}