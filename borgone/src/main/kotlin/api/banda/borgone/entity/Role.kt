package api.banda.borgone.entity

import jakarta.persistence.*

@Entity
@Table(name ="ruolo")
class Role(
    @Column(length = 30, nullable = false)
    var roleName:String,
    var active:Boolean,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idRole:Long? = null
    )
