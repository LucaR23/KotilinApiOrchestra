package api.banda.borgone.entity

import jakarta.persistence.*

@Entity
@Table(name = "strumento")
class MusicalInstrument (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idInstrument:Long,
    @Column(length = 30, nullable = false)
    var instrumentName:String,
    @Column(length = 20, nullable = true)
    var instrumentKey:String,
    var active:Boolean
)
