package api.banda.borgone.entity

import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "calendario")
data class Calendar (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idCalendar:Long,
    var startDate:LocalDate,
    var endDate:LocalDate,
    @Column(length = 50)
    var title:String,
    @Column(length = 200)
    var note:String,
    var active:Boolean
)