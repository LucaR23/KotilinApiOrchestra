package api.banda.borgone.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "musico")
class Musician (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idMusician:Long?=null,
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
        inverseJoinColumns = [JoinColumn(name = "idMusician")])
    var occurrence:List<Event>?=null,
//    @CreationTimestamp
//    var insertDate: LocalDateTime,
//    @UpdateTimestamp
//    var modificationDate: LocalDateTime
)