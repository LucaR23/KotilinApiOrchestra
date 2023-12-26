package api.banda.borgone.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "brano")
class MusicSheet (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idMusicSheet:Long?=null,
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
    var piece:List<Event>?=null,
//    @CreationTimestamp
//    var insertDate: LocalDateTime,
//    @UpdateTimestamp
//    var modificationDate: LocalDateTime
)
