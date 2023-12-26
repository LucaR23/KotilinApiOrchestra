package api.banda.borgone.service

import api.banda.borgone.dto.response.BasicResponse
import api.banda.borgone.entity.Role
import api.banda.borgone.exception.RoleNotFoundException
import api.banda.borgone.repository.RoleRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class RoleService (val roleRepo : RoleRepository) {

  // logic delete
    fun deleteRole(idRole :Long) : ResponseEntity<BasicResponse>{
      val dbRole =  roleRepo.findById(idRole).orElseThrow{RoleNotFoundException("Role not Found with id: {}$idRole")}
        dbRole.active=false
        roleRepo.save(dbRole)
      return ResponseEntity(BasicResponse(status = true, message = "Role deleted successfully", body = null), HttpStatus.OK)
    }
   fun saveRole(roleName:String) : ResponseEntity<BasicResponse> {
       roleRepo.save(Role(roleName=roleName,active = true))
       return ResponseEntity(BasicResponse(status = true, message = "Role saved successfully", body = null), HttpStatus.OK)
    }
    fun roleList(): ResponseEntity<BasicResponse>{
    val res=   roleRepo.findAllByActive(true)
        return ResponseEntity(BasicResponse(status = true, message = "Role list found successfully", body =res), HttpStatus.OK)
    }

    fun roleById(idRole:Long) : ResponseEntity<BasicResponse>{
        val res = roleRepo.findByIdRoleAndActiveTrue(idRole).orElseThrow{RoleNotFoundException("Role not Found with id: {}$idRole")}
        val list = ArrayList<Role>()
        list.add(res)
        return ResponseEntity(BasicResponse(status = true, message = "Role found successfully", body = list),HttpStatus.OK)
    }
}