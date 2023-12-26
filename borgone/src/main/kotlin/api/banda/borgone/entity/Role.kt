package api.banda.borgone.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name ="ruolo")
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idRole:Long? = null,
    @Column(length = 30, nullable = false)
    var roleName:String,
    @Column
    var active:Boolean,
//    @CreationTimestamp
//    var insertDate: LocalDateTime,
//    @UpdateTimestamp
//    var modificationDate: LocalDateTime
)
