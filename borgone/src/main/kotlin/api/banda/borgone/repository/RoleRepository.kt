package api.banda.borgone.repository

import api.banda.borgone.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface RoleRepository : JpaRepository<Role,Long > {
     fun findAllByActive(active:Boolean) : List<Role>
     fun findByIdRoleAndActiveTrue(iRole:Long) : Optional<Role>

}