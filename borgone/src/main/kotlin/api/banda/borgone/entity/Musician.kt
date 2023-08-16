package api.banda.borgone.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "musico")
data class Musician (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idMusician:Long,
    @ManyToOne
    @JoinColumn(name = "id_role")
    var idRole:Role,
    @Column(length = 30)
    var name:String,
    @Column(length = 30)
    var surname:String,
    var birthDate:LocalDate,
    @Column(length = 20)
    var taxIdCode:String,   // codice fiscale IT
    @Column(length = 15)
    var phoneNumber:String,
    @Column(length = 50)
    var email:String,
    @ManyToOne
    @JoinColumn(name="id_instrument")
    var idInstrument:MusicalInstrument,
    @Column(length = 20)
    var identificationDocument:String,
    @Column(length = 15)
    var startYear:String,
    var active:Boolean,
    var tessarate:Boolean,
    @ManyToMany
    @JoinTable(
        name = "evento_personale",
        joinColumns =[JoinColumn(name = "id_event")],
        inverseJoinColumns = [JoinColumn(name = "idMusiciant")])
    var occurrence:List<Event>
)