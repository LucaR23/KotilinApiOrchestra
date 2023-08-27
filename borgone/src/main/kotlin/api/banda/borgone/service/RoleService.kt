package api.banda.borgone.service

import api.banda.borgone.entity.Role
import api.banda.borgone.repository.RoleRepository
import org.springframework.stereotype.Service

@Service
class RoleService (val roleRepo : RoleRepository) {

  // logic delete
    fun deleteRole(idRole :Long) {
      val dbRoleOpt =  roleRepo.findById(idRole)
        var dbRole = dbRoleOpt.get()
        dbRole.active=false
        roleRepo.save(dbRole)
    }
   fun saveRole(roleName:String){
       roleRepo.save(Role(roleName=roleName,active = true))
    }
    fun roleList():List<Role>{
     return roleRepo.findAllByActive(true)
    }
}