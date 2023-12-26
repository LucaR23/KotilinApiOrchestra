package api.banda.borgone.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "strumento")
class MusicalInstrument (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idInstrument:Long? = null,
    @Column(length = 30, nullable = false)
    var instrumentName:String,
    @Column(length = 20, nullable = true)
    var instrumentKey:String,
    @Column
    var active:Boolean,
//    @CreationTimestamp
//    var insertDate: LocalDateTime,
//    @UpdateTimestamp
//    var modificationDate: LocalDateTime
)
