package api.banda.borgone.entity

import jakarta.persistence.*

@Entity
@Table(name = "brano")
data class MusicSheet(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idMusicSheet:Long,
    @Column(length = 50)
    var title:String,
    var progressiveNumber:Int,
    @Column(length = 50)
    var author:String,
    @Column(length = 1000)
    var description:String,
    @Column(length = 200)
    var note:String,
    var active:Boolean,
    @ManyToMany(mappedBy = "musicSheet")
    var piece:List<Event>
)
