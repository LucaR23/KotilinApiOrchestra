package api.banda.borgone.entity

import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name= "evento")

class Event (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idEvent:Long,
    var eventDate:LocalDate,
    @Column(length = 20)
    var eventHour:String,
    @ManyToOne
    @JoinColumn(name="id_calendar")
    var idCalenar:Calendar,
    @Column(length = 30)
    var eventPlace:String,
    @Column(length = 300)
    var description:String,
    var active:Boolean,
    @ManyToMany(mappedBy = "occurrence")
    var musician:List<Musician>,
    @ManyToMany
    @JoinTable(
        name = "brano_evento",
        joinColumns =[JoinColumn(name = "id_music_sheet")],
        inverseJoinColumns = [JoinColumn(name = "idEvent")])
    var musicSheet:List<MusicSheet>
    )