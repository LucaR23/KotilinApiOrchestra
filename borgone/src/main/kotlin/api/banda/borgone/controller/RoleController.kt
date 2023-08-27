package api.banda.borgone.controller

import api.banda.borgone.service.RoleService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/role")

class RoleController(private  val service: RoleService) {
    @Operation(summary = "API that create a new Role in the organization")
    @PostMapping("/new")
    fun addRole(roleName:String)=
        service.saveRole(roleName)
    @Operation(summary = "API that return a list of the organization Role")
     @GetMapping("/list")
     fun roleList()=
         service.roleList()
    @Operation(summary = "API to remove logically a role from the organization")
    @DeleteMapping("/delete/{idRole}")
    fun deleteRole(@PathVariable idRole:Long)=
        service.deleteRole(idRole)

}
/*TODO: validazione , gestione eccezioni , messaggi di risposta*/