package api.banda.borgone.entity

import jakarta.persistence.*

@Entity
@Table(name ="ruolo")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idRole:Long,
    @Column(length = 30, nullable = false)
    var roleName:String,
    var active:Boolean
)
