package api.banda.borgone.controller

import api.banda.borgone.dto.response.BasicResponse
import api.banda.borgone.exception.RoleNotFoundException
import api.banda.borgone.service.RoleService
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/role")
@Validated
class RoleController(private  val service: RoleService) {
    @Operation(summary = "API that create a new Role in the organization")
    @PostMapping("/new")
    fun addRole(@NotBlank @Size(min = 2, max = 30) roleName:String) : ResponseEntity<BasicResponse> {
      return   service.saveRole(roleName)
    }
     @Operation(summary = "API that return a list of the organization Role")
     @GetMapping("/list")
     fun roleList(): ResponseEntity<BasicResponse> {
        return  service.roleList()
    }
    @Operation(summary = "API to remove logically a role from the organization")
    @DeleteMapping("/delete/{idRole}")
    fun deleteRole(@PathVariable  @NotNull @Min(1) idRole:Long)  : ResponseEntity<BasicResponse> {
        try {
            return service.deleteRole(idRole)
        }catch (e:RoleNotFoundException) {
            return ResponseEntity(BasicResponse(message =e.message.toString(), status = false, body = null),HttpStatus.NOT_FOUND)
        }
    }
    @Operation(summary = "API to get a role by is Id")
    @GetMapping("/get/{idRole}")
    fun getById(@PathVariable @NotNull @Min(1) idRole: Long) : ResponseEntity<BasicResponse>{
      try {
          return service.roleById(idRole);
      }catch (e:RoleNotFoundException){
          return ResponseEntity(BasicResponse(message =e.message.toString(), status = false, body = null),HttpStatus.NOT_FOUND)
      }
    }
}
